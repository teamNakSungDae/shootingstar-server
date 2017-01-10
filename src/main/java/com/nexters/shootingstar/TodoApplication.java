package com.nexters.shootingstar;

import com.nexters.shootingstar.dao.UserDao;
import com.nexters.shootingstar.health.TemplateHealthCheck;
import com.nexters.shootingstar.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import java.io.File;
import java.net.URL;

/**
 * Created by yoon on 2017. 1. 4..
 */
public class TodoApplication extends Application<TodoConfiguration> {
    public static void main(final String[] args) throws Exception {
        URL url = TodoApplication.class.getClassLoader().getResource("config/development.yml");
        new TodoApplication().run("server", new File(url.toURI()).getAbsolutePath());
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<TodoConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
    }

    @Override
    public void run(TodoConfiguration configuration, Environment environment) {
        // DataBase
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final UserDao dao = jdbi.onDemand(UserDao.class);

        // Resources
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName(),
                dao
        );

        // Health check
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}