package com.akm.config;

import io.dropwizard.Configuration;

public class MyAppConfiguration extends Configuration {
    private String appName;
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

}
