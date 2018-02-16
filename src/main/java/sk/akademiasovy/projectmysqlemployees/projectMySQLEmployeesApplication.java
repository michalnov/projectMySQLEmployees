package sk.akademiasovy.projectmysqlemployees;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sk.akademiasovy.projectmysqlemployees.resources.BrowseEmployees;

public class projectMySQLEmployeesApplication extends Application<projectMySQLEmployeesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new projectMySQLEmployeesApplication().run(args);
    }

    @Override
    public String getName() {
        return "projectMySQLEmployees";
    }

    @Override
    public void initialize(final Bootstrap<projectMySQLEmployeesConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final projectMySQLEmployeesConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(
                new BrowseEmployees()
        );
    }

}
