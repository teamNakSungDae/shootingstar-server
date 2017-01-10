package com.nexters.shootingstar.resources;

import com.codahale.metrics.annotation.Timed;
import com.nexters.shootingstar.core.Saying;
import com.nexters.shootingstar.dao.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yoon on 2017. 1. 4..
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private final UserDao userDao;

    public HelloWorldResource(String template, String defaultName, UserDao dao) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.userDao = dao;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        return new Saying(counter.incrementAndGet(),
                String.format(template, name.orElse(userDao.findNameById(1))));
    }
}