package com.mvc.resources;

import com.codahale.metrics.annotation.Timed;
import com.mvc.api.User;
import com.mvc.db.UserDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/User")
public class UserService {

    public UserService() {
    }

    @GET
    @Timed
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id) {
        return UserDB.getById(id);
    }

    @GET
    @Timed
    @Path("/remove")
    @Produces(MediaType.TEXT_PLAIN)
    public String removeUser() {
        UserDB.remove();
        return "Last User remove. Total count: " + UserDB.getCount();
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return UserDB.getAll();
    }

    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addUser(User User) {
        return UserDB.save(User);
    }
}