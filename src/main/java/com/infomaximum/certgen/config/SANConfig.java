package com.infomaximum.certgen.config;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class SANConfig {

    private String name;
    private List<String> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    @XmlElement(name = "value")
    public void setValues(List<String> values) {
        this.values = values;
    }
}
