package com.nexters.shootingstar.auth;

import com.nexters.shootingstar.models.AccessToken;
import io.dropwizard.auth.AuthFilter;
import lombok.AllArgsConstructor;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by yoon on 2017. 1. 16..
 */
@AllArgsConstructor
@PreMatching
@Priority(Priorities.AUTHENTICATION)
public class ShootingStarOAuthFilter extends AuthFilter {
    private ShootingStarOAuthAuthenticator authenticator;


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String email = requestContext
                .getHeaders()
                .get("email")
                .toString();
        String token = requestContext
                .getHeaders()
                .get("token")
                .toString();
        AccessToken accessToken = new AccessToken(email, token);

        try {
            if (!authenticator.authenticate(accessToken).isPresent()) {
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
