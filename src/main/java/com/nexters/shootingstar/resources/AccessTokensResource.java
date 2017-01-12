package com.nexters.shootingstar.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.persist.Transactional;
import com.nexters.shootingstar.db.dao.AccessTokenDao;
import com.nexters.shootingstar.models.AccessToken;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
        AccessToken accessToken = accessTokenDao.findTokenByEmail(email);
        return accessToken;
    }

    @POST
    @Timed
    public AccessToken postAccessToken(@Valid AccessToken accessToken) {
        accessTokenDao.create(accessToken.getEmail(), accessToken.getAccessToken());
        return accessToken;
    }
}
