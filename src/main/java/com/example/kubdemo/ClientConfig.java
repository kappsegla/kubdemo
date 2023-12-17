package com.example.kubdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bean")
public class ClientConfig {

    //If we don't specify a ConfigMap, then we should expect to see the default message, which is set in the class. However, when we create the ConfigMap, this default message gets overridden by that property.
    private String message = "Hello World";

    private boolean showheaders = false;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isShowheaders() {
        return showheaders;
    }

    public void setShowheaders(boolean showheaders) {
        this.showheaders = showheaders;
    }
}
