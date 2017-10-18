package io.orten.nano.business;

import io.orten.nano.impl.UserService;

import io.orten.nano.model.User;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class UserAPI {

    public static List<User> u_list = new ArrayList<User>();

    @GET
    @Path("/get/user/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userID") long userID) {
        try {
            User user = UserService.getUser(userID);
            return Response.status(200).entity(user).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/get/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        try {
            List<User> users = UserService.getUsers();
            return Response.status(200).entity(users).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/get/users/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByName(@PathParam("userName") String userName) {
        try {
            List<User> users = UserService.getUsersByName(userName);
            return Response.status(200).entity(users).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/post/user")
    public Response saveUser(User user) {
        try {
            UserService.saveUser(user);
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("/delete/user/{userID}")
    public Response deleteUser(@PathParam("userID") String userID) {
        try {
            UserService.deleteUser(userID);
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }
}