package com.infomaximum.certgen.generator;

public class CAGenerator implements CertGenerator {

    @Override
    public void execute() {
        genKey("c:\\ca.key");
    }
}
