package com.infomaximum.certgen;

import com.infomaximum.certgen.config.Config;
import com.infomaximum.certgen.context.CertContext;
import com.infomaximum.certgen.parser.ConfigParser;

public class CertgenApp {

    private static CertContext certContext = null;
    private Config config;

    public CertgenApp(CertContext certContext) {
        CertgenApp.certContext = certContext;
    }

    private static CertContext getContext() {
        return certContext;
    }

    public void run() {
        this.config = ConfigParser.parseConfig(certContext.getCertgenConf());
        buildToolsEnvironment();
    }

    private void buildToolsEnvironment() {
//        toolEnvironment = new CertContext(openSSLPath, keyToolPath);

    }
}
