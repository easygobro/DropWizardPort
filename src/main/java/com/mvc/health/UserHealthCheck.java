package com.mvc.health;

import com.codahale.metrics.health.HealthCheck;
import com.mvc.db.UserDB;

public class UserHealthCheck extends HealthCheck {
    private final String version;

    public UserHealthCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        if (UserDB.getCount() == 0) {
            return Result.unhealthy("No persons in DB! Version: " +
                    this.version);
        }
        return Result.healthy("OK with version: " + this.version +
                ". Persons count: " + UserDB.getCount());
    }
}
