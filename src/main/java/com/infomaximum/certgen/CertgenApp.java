package com.infomaximum.certgen;

import com.infomaximum.certgen.config.Config;
import com.infomaximum.certgen.context.CertContext;
import com.infomaximum.certgen.parser.ConfigParser;

class CertgenApp {

    private static CertContext certContext = null;

    CertgenApp(CertContext certContext) {
        CertgenApp.certContext = certContext;
    }

    private static CertContext getContext() {
        return certContext;
    }

    void run() {
        Config config = ConfigParser.parseConfig(certContext.getCertgenConf());
        CertGenerators.generateCA(config.getCa(), certContext);
    }
}
