package com.mvc;

import com.mvc.health.TemplateHealthCheck;
import com.mvc.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardPortApplication extends Application<DropWizardPortConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardPortApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardPortConfiguration> bootstrap) {
        AssetsBundle assetsBundle = new AssetsBundle("/assests/", "/", "index.html");
        bootstrap.addBundle(assetsBundle);
    }

    @Override
    public void run(final DropWizardPortConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
