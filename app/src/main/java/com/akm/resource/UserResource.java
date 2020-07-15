package com.akm.resource;


import com.akm.dao.UserDao;
import com.akm.entity.UserEntity;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("app/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserDao userDao;

    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Path("/{id}")
    @Timed
    @UnitOfWork
    public UserEntity findPerson(@PathParam("id") LongParam id) {
        return userDao.getById(id.get());
    }

    @POST
    @Path("/")
    @Timed
    @UnitOfWork
    public UserEntity addUser(UserEntity userEntity){
        return userDao.save(userEntity);
    }
}