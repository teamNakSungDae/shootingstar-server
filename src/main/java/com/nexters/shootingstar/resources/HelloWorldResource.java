package com.nexters.shootingstar.resources;

import com.codahale.metrics.annotation.Timed;
import com.nexters.shootingstar.models.User;
import io.dropwizard.auth.Auth;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by yoon on 2017. 1. 4..
 */
@Path("/hello_world")
@Produces(MediaType.APPLICATION_JSON)
@NoArgsConstructor
public class HelloWorldResource {
    @GET
    @Timed
    public Response sayHello(@NotBlank @QueryParam("name") String name) {
        return Response.ok("hello! " + name).build();
    }

    @GET
    @Timed
    @Path("/auth")
    public Response sayHelloToAuth(@Auth User user) {
        return Response.ok("hello! " + user).build();
    }
}