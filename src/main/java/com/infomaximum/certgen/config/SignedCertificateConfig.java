package com.infomaximum.certgen.config;

public abstract class SignedCertificateConfig extends CertificateConfig{

    private String signerLink;

    public String getSignerLink() {
        return signerLink;
    }

    public void setSignerLink(String signerLink) {
        this.signerLink = signerLink;
    }
}
