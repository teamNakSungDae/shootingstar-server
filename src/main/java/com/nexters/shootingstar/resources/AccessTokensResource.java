package com.nexters.shootingstar.resources;

import com.codahale.metrics.annotation.Timed;
import com.nexters.shootingstar.db.dao.AccessTokenDao;
import com.nexters.shootingstar.models.AccessToken;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

/**
 * Created by yoon on 2017. 1. 12..
 */
@Path("/access_tokens")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class AccessTokensResource {
    @NonNull
    private final AccessTokenDao accessTokenDao;

    @GET
    @Timed
    public AccessToken getAccessToken(@QueryParam("email") String email) {
        Optional<AccessToken> accessToken = accessTokenDao.findAccessTokenByEmail(email);
        return accessToken.orElse(null);
    }

    @POST
    @Timed
    public AccessToken postAccessToken(@Valid AccessToken accessToken) {
        accessTokenDao.create(accessToken.getEmail(), accessToken.getToken());
        return accessToken;
    }
}
