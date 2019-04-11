package com.infomaximum.certgen.config.truststore;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TruststoreConfig {

    private String name;
    private List<CertOfTruststore> certs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CertOfTruststore> getCerts() {
        return certs;
    }

    @XmlElement(name = "cert")
    public void setCerts(List<CertOfTruststore> certs) {
        this.certs = certs;
    }
}
