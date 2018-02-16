package sk.akademiasovy;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sk.akademiasovy.resources.Heroes;

public class projectEmployeeApplication extends Application<projectEmployeeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new projectEmployeeApplication().run(args);
    }

    @Override
    public String getName() {
        return "projectEmployee";
    }

    @Override
    public void initialize(final Bootstrap<projectEmployeeConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final projectEmployeeConfiguration configuration,
                    final Environment environment) {

        environment.jersey().register(
                new Heroes()
        );

    }

}
