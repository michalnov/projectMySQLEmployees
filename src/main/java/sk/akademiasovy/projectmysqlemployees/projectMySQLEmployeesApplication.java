package sk.akademiasovy.projectmysqlemployees;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sk.akademiasovy.projectmysqlemployees.resources.BrowseEmployees;
import sk.akademiasovy.projectmysqlemployees.resources.Home;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import sk.akademiasovy.projectmysqlemployees.resources.Resources;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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
        //final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

// Configure CORS parameters
        //cors.setInitParameter("allowedOrigins", "*");
        //cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        //cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

// Add URL mapping
        //cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        // TODO: implement application
        environment.jersey().register(
                new BrowseEmployees()
        );
        environment.jersey().register(
                new Home()
        );
        environment.jersey().register(
                new Resources()
        );
    }

}
