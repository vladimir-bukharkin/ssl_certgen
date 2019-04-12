package com.infomaximum.certgen;

import com.infomaximum.certgen.cmd.generator.CAGenerator;
import com.infomaximum.certgen.config.ca.CAConfig;
import com.infomaximum.certgen.context.CertContext;


public class CertGenerators {

    private final static CAGenerator CA_GENERATOR = new CAGenerator();

    private CertGenerators() {
    }

    public static void generateCA(CAConfig config, CertContext context) {
        CA_GENERATOR.execute(config, context);
    }
}
