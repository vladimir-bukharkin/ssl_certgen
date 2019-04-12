package com.infomaximum.certgen.cmd.generator;

import com.infomaximum.certgen.cmd.TerminalExecutor;
import com.infomaximum.certgen.context.CertContext;

@FunctionalInterface
public interface CertGenerator<T> {

    String PRIVATE_KEY_EXT = ".key";
    String CRT_EXT = ".crt";
    String GEN_PRIVATE_KEY = "%s genrsa -out %s\\%s" + PRIVATE_KEY_EXT + " 4096";

    void execute(T config, CertContext context);

    default void generatePrivateKey(String name, CertContext context) {
        TerminalExecutor.execute(String.format(GEN_PRIVATE_KEY, context.getOpenSSLPath(), context.getOutFolder(), name));
    }
}
