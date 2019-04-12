package com.infomaximum.certgen.cmd.generator;

import com.infomaximum.certgen.cmd.TerminalExecutor;
import com.infomaximum.certgen.config.ca.CAConfig;
import com.infomaximum.certgen.context.CertContext;

public class CAGenerator implements CertGenerator<CAConfig> {

    private final static String SUBJ = "/C=%s/ST=%s/O=%s/CN=%s";
    private final static String CMD = "%s req -new -sha256 -x509 -days %d -key %s\\%s"
            + PRIVATE_KEY_EXT
            + " -subj " + SUBJ
            + " -reqexts v3_ca -out %s\\%s" + CRT_EXT;

    @Override
    public void execute(CAConfig config, CertContext context) {
        generatePrivateKey(config.getName(), context);
        generateSelfSignedCA(config, context);
    }

    private void generateSelfSignedCA(CAConfig config, CertContext context) {
//        TerminalExecutor.execute(String.format(CMD, context.getOpenSSLPath(), config.getDays(), context.getOutFolder(), name));
    }
}
