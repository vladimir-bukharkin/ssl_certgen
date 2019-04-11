package com.infomaximum.certgen.config;

import javax.xml.bind.annotation.XmlElement;

public abstract class SignedCertificateConfig extends CertificateConfig{

    private String signerLink;

    public String getSignerLink() {
        return signerLink;
    }

    @XmlElement
    public void setSignerLink(String signerLink) {
        this.signerLink = signerLink;
    }
}
