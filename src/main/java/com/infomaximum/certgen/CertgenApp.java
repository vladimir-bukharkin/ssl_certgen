package com.infomaximum.certgen;

import com.infomaximum.certgen.config.CAConfig;
import com.infomaximum.certgen.context.CertContext;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CertgenApp {

    private static CertContext certContext = null;

    public CertgenApp(CertContext certContext) {
        CertgenApp.certContext = certContext;
    }

    private static CertContext getContext() {
        return certContext;
    }

    public void run() {
        Path certgenPath = Paths.get(certContext.getCertgenConf());
        CAConfig caConfig = new CAConfig.Builder()
                .fromConfigFile(certgenPath, "ca_root")
                .build();

        buildToolsEnvironment();
    }

    private void buildToolsEnvironment() {
//        toolEnvironment = new CertContext(openSSLPath, keyToolPath);

    }
}
