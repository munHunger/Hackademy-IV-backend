package io.orten.nano.business;

import io.orten.nano.impl.DonorService;
import io.orten.nano.model.Donor;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class DonorAPI {

    public static List<Donor> donorList = new ArrayList<Donor>();

    @GET
    @Path("/getuser/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userID") long userID) {
        try {
            Donor donor = DonorService.getUser(userID);
            return Response.status(HttpServletResponse.SC_OK).entity(donor).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getlistofusers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        try {
            List<Donor> donors = DonorService.getUsers();
            return Response.status(HttpServletResponse.SC_OK).entity(donors).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getlistofusersbyusername/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByName(@PathParam("userName") String userName) {
        try {
            List<Donor> donors = DonorService.getUsersByName(userName);
            return Response.status(HttpServletResponse.SC_OK).entity(donors).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/saveuser")
    public Response saveUser(Donor donor) {
        try {
            DonorService.saveUser(donor);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/deleteuser/{userID}")
    public Response deleteUser(@PathParam("userID") Long  userID) {
        try {
            DonorService.deleteUser(userID);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }
}