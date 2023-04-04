package com.mvc;

import com.codahale.metrics.health.HealthCheck;
import com.mvc.resources.EventResource;
import com.mvc.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DropWizardPortApplication extends Application<DropWizardPortConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardPortApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizardPort";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardPortConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropWizardPortConfiguration configuration,
                    final Environment environment) {
        DateFormat eAppDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eAppDateFormat);
        environment.jersey().register(new EventResource());
        environment.jersey().register(new HelloWorldResource());

        environment.healthChecks().register("dropwizardport", new HealthCheck() {
            @Override
            protected Result check() throws Exception {
                return Result.healthy();
            }
        });
    }

}
