package com.infomaximum.certgen.generator;

import com.infomaximum.certgen.cmd.CmdExecutor;

@FunctionalInterface
public interface CertGenerator {

    String GEN_KEY = "D:\\Programs\\OpenSSL\\bin\\openssl genrsa -out %s 4096";

    void execute();

    default void genKey(String path) {
        CmdExecutor.execute(String.format(GEN_KEY, path));
    }
}
