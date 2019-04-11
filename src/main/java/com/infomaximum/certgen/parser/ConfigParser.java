package com.infomaximum.certgen.parser;

import com.infomaximum.certgen.config.Config;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Paths;

public class ConfigParser {

    public static Config parseConfig(String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Config config = (Config) jaxbUnmarshaller.unmarshal(Paths.get(path).toFile());
            return config;

        } catch (JAXBException e) {
            throw new RuntimeException("Can't parse certgen conf: " + path ,e);
        }
    }
}
