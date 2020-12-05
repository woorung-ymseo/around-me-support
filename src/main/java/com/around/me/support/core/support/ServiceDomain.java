package com.around.me.support.core.support;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "service")
public class ServiceDomain {

    private HashMap<String, String> domain;

    public String getDomain(String serviceName) {
        return domain.get(serviceName);
    }

    public void setDomain(HashMap<String, String> domain) {
        this.domain = domain;
    }
}
