package com.akm;

import com.akm.config.MyAppConfiguration;
import com.akm.dao.UserDao;
import com.akm.entity.UserEntity;
import com.akm.health.MyAppHealthCheck;
import com.akm.resource.HelloWorldResource;
import com.akm.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class Main extends Application<MyAppConfiguration> {
    public static void main(String [] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void initialize(Bootstrap<MyAppConfiguration> bootstrap){
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(MyAppConfiguration configuration, Environment environment) throws Exception {
        addResources(environment);
        addHealthCheck(environment);
    }

    private void addHealthCheck(Environment environment) {
        environment.jersey().register(new UserResource(new UserDao(hibernateBundle.getSessionFactory())));
        environment.jersey().register(HelloWorldResource.class);
    }

    private void addResources(Environment environment) {
        environment.healthChecks().register("myApp", new MyAppHealthCheck());
    }

    private final HibernateBundle<MyAppConfiguration> hibernateBundle = new HibernateBundle<MyAppConfiguration>(UserEntity.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(MyAppConfiguration configuration) {
            return configuration.getDatabase();
        }
    };
}