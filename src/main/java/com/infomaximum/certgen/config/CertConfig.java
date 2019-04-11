package com.infomaximum.certgen.config;

import java.util.Map;
import java.util.Objects;

class CertConfig<T extends CertConfig> {

    private String name;
    private String countryName;
    private String stateOrProvinceName;
    private String organizationName;
    private String organizationalUnitName;
    private String commonName;
    private String emailAddress;
    private Integer days;

    protected CertConfig(Builder<T> builder) {
        validate(builder);
        this.name = builder.name;
        this.countryName = builder.countryName;
        this.stateOrProvinceName = builder.stateOrProvinceName;
        this.organizationName = builder.organizationName;
        this.organizationalUnitName = builder.organizationalUnitName;
        this.commonName = builder.commonName;
        this.emailAddress = builder.emailAddress;
        this.days = builder.days;
    }

    protected abstract static class Builder<T> {

        private String name = null;
        private String countryName = null;
        private String stateOrProvinceName = null;
        private String organizationName = null;
        private String organizationalUnitName = null;
        private String commonName = null;
        private String emailAddress = null;
        private Integer days = null;

        public Builder<T> withName(String name) {
            this.name = name;
            return this;
        }

        public Builder<T> withCountryName(String name) {
            this.countryName = name;
            return this;
        }

        public Builder<T> withStateOrProvinceName(String name) {
            this.stateOrProvinceName = name;
            return this;
        }

        public Builder<T> withOrganizationName(String name) {
            this.organizationName = name;
            return this;
        }

        public Builder<T> withOrganizationalUnitName(String name) {
            this.organizationalUnitName = name;
            return this;
        }

        public Builder<T> withCommonName(String name) {
            this.commonName = name;
            return this;
        }

        public Builder<T> withEmailAddress(String email) {
            this.emailAddress = email;
            return this;
        }

        public Builder<T> withDays(int days) {
            this.days = days;
            return this;
        }

        void setParameters(Map<String, String> parameters) {
            parameters.forEach((k, v) -> {
                switch (k) {
                    case "name":
                        withName(v);
                        break;
                    case "countryName":
                        withCountryName(v);
                        break;
                    case "stateOrProvinceName":
                        withStateOrProvinceName(v);
                        break;
                    case "organizationName":
                        withOrganizationName(v);
                        break;
                    case "organizationalUnitName":
                        withOrganizationalUnitName(v);
                        break;
                    case "commonName":
                        withCommonName(v);
                        break;
                    case "emailAddress":
                        withEmailAddress(v);
                        break;
                    case "days":
                        withDays(Integer.parseInt(v));
                        break;
                }
            });
        }

        public abstract T build();
    }

    private void validate(Builder<T> builder) {
        Objects.requireNonNull(builder.name);
        Objects.requireNonNull(builder.countryName);
        Objects.requireNonNull(builder.stateOrProvinceName);
        Objects.requireNonNull(builder.organizationalUnitName);
        Objects.requireNonNull(builder.organizationName);
        Objects.requireNonNull(builder.commonName);
        Objects.requireNonNull(builder.emailAddress);
        Objects.requireNonNull(builder.days);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setStateOrProvinceName(String stateOrProvinceName) {
        this.stateOrProvinceName = stateOrProvinceName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setOrganizationalUnitName(String organizationalUnitName) {
        this.organizationalUnitName = organizationalUnitName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
