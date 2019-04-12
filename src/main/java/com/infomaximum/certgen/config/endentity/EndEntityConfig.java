package com.infomaximum.certgen.config.endentity;

import com.infomaximum.certgen.config.SignedCertificateConfig;

public class EndEntityConfig extends SignedCertificateConfig {

    private String sanLink;
    private String password;

    public String getSanLink() {
        return sanLink;
    }

    public void setSanLink(String sanLink) {
        this.sanLink = sanLink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
