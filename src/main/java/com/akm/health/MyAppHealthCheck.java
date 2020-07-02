package com.akm.health;

import com.codahale.metrics.health.HealthCheck;

public class MyAppHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
