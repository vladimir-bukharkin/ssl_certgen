package com.infomaximum.certgen.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdExecutor {

    public static void execute(String command) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            new BufferedReader(new InputStreamReader(p.getInputStream()))
                    .lines()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
