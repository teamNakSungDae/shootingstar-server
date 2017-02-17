package com.nexters.shootingstar;

import com.nexters.shootingstar.auth.ShootingStarOAuthAuthenticator;
import com.nexters.shootingstar.auth.ShootingStarOAuthFilter;
import com.nexters.shootingstar.auth.ShootingStarOAuthValueFactoryProvider;
import com.nexters.shootingstar.db.dao.AccessTokenDao;
import com.nexters.shootingstar.db.dao.UserDao;
import com.nexters.shootingstar.health.TemplateHealthCheck;
import com.nexters.shootingstar.models.User;
import com.nexters.shootingstar.resources.AccessTokensResource;
import com.nexters.shootingstar.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import java.io.File;

;

/**
 * Created by yoon on 2017. 1. 4..
 */
public class TodoApplication extends Application<TodoConfiguration> {
    public static void main(final String[] args) throws Exception {
        new TodoApplication().run("server", new File("src/main/resources/config/development.yml").getAbsolutePath());
    }

    @Override
    public String getName() {
        return "todo-server";
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
        final UserDao userDao = jdbi.onDemand(UserDao.class);
        final AccessTokenDao accessTokenDao = jdbi.onDemand(AccessTokenDao.class);

        // Auth
        final ShootingStarOAuthAuthenticator authenticator = new ShootingStarOAuthAuthenticator(accessTokenDao);
        final ShootingStarOAuthFilter authFilter = new ShootingStarOAuthFilter(authenticator);

        // Resources
        final HelloWorldResource resource = new HelloWorldResource();
        final AccessTokensResource accessTokensResource = new AccessTokensResource(accessTokenDao);

        // Health check
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(accessTokensResource);
        environment.jersey().register(new AuthDynamicFeature(authFilter));
        environment.jersey().register(new ShootingStarOAuthValueFactoryProvider.Binder<>(User.class));
    }
}