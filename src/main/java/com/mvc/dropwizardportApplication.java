package com.mvc;

import com.mvc.api.User;
import com.mvc.health.UserHealthCheck;
import com.mvc.resources.UserService;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import org.skife.jdbi.v2.DBI;


public class dropwizardportApplication extends Application<dropwizardportConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropwizardportApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<dropwizardportConfiguration> bootstrap) {

    }

    @Override
    public void run(final dropwizardportConfiguration configuration,
                    final Environment environment) {
        final UserService userService = new UserService();
        environment.jersey().register(userService);

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        environment.healthChecks().register("template",
                new UserHealthCheck(configuration.getVersion()));
    }
}
