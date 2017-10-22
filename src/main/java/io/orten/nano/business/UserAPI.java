package io.orten.nano.business;

import io.orten.nano.impl.UserService;
import io.orten.nano.model.User;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class UserAPI {

    public static List<User> userList = new ArrayList<User>();

    @GET
    @Path("/getuser/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userID") long userID) {
        try {
            User user = UserService.getUser(userID);
            return Response.status(HttpServletResponse.SC_OK).entity(user).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getlistofusers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        try {
            List<User> users = UserService.getUsers();
            return Response.status(HttpServletResponse.SC_OK).entity(users).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getlistofusersbyusername/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByName(@PathParam("userName") String userName) {
        try {
            List<User> users = UserService.getUsersByName(userName);
            return Response.status(HttpServletResponse.SC_OK).entity(users).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/saveuser")
    public Response saveUser(User user) {
        try {
            UserService.saveUser(user);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/deleteuser/{userID}")
    public Response deleteUser(@PathParam("userID") Long  userID) {
        try {
            UserService.deleteUser(userID);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }
}