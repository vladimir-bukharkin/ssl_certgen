package com.infomaximum.certgen.context;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CertContext {

    private final static String CERTGEN_CONF = "certgenConf=";
    private final static String OPENSSL = "openssl=";
    private final static String KEYTOOL = "keytool=";
    private final static String OUT_FOLDER = "outFolder=";

    private final static String TEMP_FOLDER_PREFIX = "cert_conf";

    private String openSSLPath = null;
    private String keyToolPath = null;
    private String outFolder = null;
    private String certgenConf = null;
    private Path tempFolder = null;

    private CertContext() {
    }

    public static CertContext build(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("No arguments set");
        }
        CertContext certContext = new CertContext();
        for (String arg : args) {
            if (arg.startsWith(CERTGEN_CONF)) {
                certContext.certgenConf = arg.trim().substring(CERTGEN_CONF.length());
            } else if (arg.startsWith(OPENSSL)) {
                certContext.openSSLPath = arg.trim().substring(OPENSSL.length());
            } else if (arg.startsWith(KEYTOOL)) {
                certContext.keyToolPath = arg.trim().substring(KEYTOOL.length());
            } else if (arg.startsWith(OUT_FOLDER)) {
                certContext.outFolder = arg.trim().substring(OUT_FOLDER.length());
            }
        }
        certContext.tempFolder = createTempFolder();
        return certContext;
    }

    public String getOpenSSLPath() {
        return openSSLPath;
    }

    public String getKeyToolPath() {
        return keyToolPath;
    }

    public String getOutFolder() {
        return outFolder;
    }

    public String getCertgenConf() {
        return certgenConf;
    }

    public Path getTempFolder() {
        return tempFolder;
    }

    private static Path createTempFolder() {
        try {
            Path tempFolder = Files.createTempDirectory(TEMP_FOLDER_PREFIX);
            tempFolder.toFile().deleteOnExit();
            return tempFolder;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
