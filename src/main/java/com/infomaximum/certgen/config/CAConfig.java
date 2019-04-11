package com.infomaximum.certgen.config;

import com.infomaximum.certgen.parser.CertGenConfigParser;

import java.nio.file.Path;
import java.util.Map;

public class CAConfig extends CertConfig<CAConfig> {

    private CAConfig(Builder builder) {
        super(builder);
    }

    public static class Builder extends CertConfig.Builder<CAConfig> {

        public Builder fromConfigFile(Path path, String certName) {
            Map<String, String> certParameters = CertGenConfigParser.getParameters(path, "ca", certName);
            setParameters(certParameters);
            return this;
        }

        @Override
        public CAConfig build() {
            return new CAConfig(this);
        }
    }
}
