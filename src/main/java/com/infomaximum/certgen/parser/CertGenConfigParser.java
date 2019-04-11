package com.infomaximum.certgen.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CertGenConfigParser {

    private final static Pattern BLOCK_PATTERN = Pattern.compile("\\[.*]");

    public static HashMap<String, String> getParameters(Path path, String blockTitle, String name) {
        HashMap<String, String> parameters = new HashMap<>();

        try (Stream<String> stream = Files.lines(path)) {
            int lineN = 0;
            Iterator<String> it = stream.iterator();
            boolean isPassedBlockTitle = false;
            while (it.hasNext()) {
                lineN++;
                String cur = it.next();
                if (isPassedBlockTitle) {
                    if (isBlock(cur)) {
                        String pName = parameters.get("name");
                        if (Objects.equals(name, pName)) {
                            return parameters;
                        } else {
                            parameters.clear();
                            isPassedBlockTitle = false;
                        }
                    } else {
                        putParameterKey(parameters, cur, lineN);
                        continue;
                    }
                }
                if (isBlock(cur) && cur.contains(blockTitle)) {
                    isPassedBlockTitle = true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parameters;
    }

    private static void putParameterKey(HashMap<String, String> parameters, String line, int lineN) {
        line = line.trim();
        if (line.length() == 0) {
            return;
        }
        int indexOfEq = line.indexOf("=");
        if (indexOfEq <= 0) {
            throw new RuntimeException("Certgen config parse error on line: " + lineN);
        }
        String key = line.substring(0, indexOfEq).trim();
        String value = line.substring(indexOfEq + 1).trim();
        parameters.put(key, value);
    }

    private static boolean isBlock(String line) {
        return BLOCK_PATTERN.matcher(line).matches();
    }
}
