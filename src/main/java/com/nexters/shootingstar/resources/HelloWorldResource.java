package com.nexters.shootingstar.resources;

import com.codahale.metrics.annotation.Timed;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
    public Response sayHello(@NonNull @QueryParam("name") String name) {
        return Response.ok("hello! " + name).build();
    }
}