package com.infomaximum.certgen.config.endentity;

import com.infomaximum.certgen.config.SignedCertificateConfig;

import javax.xml.bind.annotation.XmlElement;


public class EndEntityConfig extends SignedCertificateConfig {

    private String sanLink;

    public String getSanLink() {
        return sanLink;
    }

    @XmlElement
    public void setSanLink(String sanLink) {
        this.sanLink = sanLink;
    }
}
