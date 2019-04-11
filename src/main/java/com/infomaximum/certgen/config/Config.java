package com.infomaximum.certgen.config;

import com.infomaximum.certgen.config.Intermediate.IntermediateConfig;
import com.infomaximum.certgen.config.ca.CAConfig;
import com.infomaximum.certgen.config.endentity.EndEntityConfig;
import com.infomaximum.certgen.config.truststore.TruststoreConfig;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Config {

    private CAConfig ca;
    private List<IntermediateConfig> intermediateConfigs;
    private List<EndEntityConfig> endEntityConfigs;
    private List<TruststoreConfig> truststoreConfigs;
    private List<SANConfig> sanConfigs;

    public CAConfig getCa() {
        return ca;
    }

    public void setCa(CAConfig ca) {
        this.ca = ca;
    }

    public List<IntermediateConfig> getIntermediateConfigs() {
        return intermediateConfigs;
    }

    @XmlElement(name = "intermediate")
    public void setIntermediateConfigs(List<IntermediateConfig> intermediates) {
        this.intermediateConfigs = intermediates;
    }

    public List<EndEntityConfig> getEndEntityCongigs() {
        return endEntityConfigs;
    }

    @XmlElement(name = "endEntity")
    public void setEndEntityConfigs(List<EndEntityConfig> endEntityConfigs) {
        this.endEntityConfigs = endEntityConfigs;
    }

    public List<TruststoreConfig> getTruststoreConfigs() {
        return truststoreConfigs;
    }

    @XmlElement(name = "truststore")
    public void setTruststoreConfigs(List<TruststoreConfig> truststoreConfigs) {
        this.truststoreConfigs = truststoreConfigs;
    }

    public List<EndEntityConfig> getEndEntityConfigs() {
        return endEntityConfigs;
    }

    public List<SANConfig> getSanConfigs() {
        return sanConfigs;
    }

    @XmlElement(name = "altName")
    public void setSanConfigs(List<SANConfig> sanConfigs) {
        this.sanConfigs = sanConfigs;
    }
}
