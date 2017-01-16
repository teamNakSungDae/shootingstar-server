package com.nexters.shootingstar.auth;

import com.nexters.shootingstar.db.dao.AccessTokenDao;
import com.nexters.shootingstar.models.AccessToken;
import com.nexters.shootingstar.models.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import lombok.AllArgsConstructor;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Created by yoon on 2017. 1. 15..
 */
@AllArgsConstructor
public class ShootingStarOAuthAuthenticator implements Authenticator<AccessToken, User> {
    private final AccessTokenDao accessTokenDao;


    @Override
    public Optional<User> authenticate(AccessToken accessToken) throws AuthenticationException {
        // Get access token from database.
        String email = accessToken.getEmail();
        String token = accessToken.getToken();
        email = email.substring(1, email.length() - 1);
        token = token.substring(1, token.length() - 1);
        Optional<AccessToken> accessTokenFromDB = accessTokenDao.findAccessTokenByEmail(email);
        if (accessTokenFromDB.isPresent()) {
            String tokenFromDB = accessTokenFromDB.get().getToken();
            if (!token.equals(tokenFromDB)) {
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
            return Optional.of(new User(email));
        }
        return null;
    }
}
