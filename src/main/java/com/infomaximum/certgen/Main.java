package com.infomaximum.certgen;

import com.infomaximum.certgen.context.CertContext;


public class Main {

    public static void main(String[] args) {
        CertContext certContext = CertContext.build(args);
        CertgenApp app = new CertgenApp(certContext);
        app.run();
    }
}
