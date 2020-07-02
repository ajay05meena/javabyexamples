package com.akm;

import com.akm.config.MyAppConfiguration;
import com.akm.health.MyAppHealthCheck;
import com.akm.resource.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;


public class Main extends Application<MyAppConfiguration> {
    public static void main(String [] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(MyAppConfiguration configuration, Environment environment) throws Exception {
        addResources(environment);
        addHealthCheck(environment);
    }

    private void addHealthCheck(Environment environment) {
        environment.jersey().register(HelloWorldResource.class);
    }

    private void addResources(Environment environment) {
        environment.healthChecks().register("myApp", new MyAppHealthCheck());
    }
}
