package io.orten.nano.business;

import io.orten.nano.impl.OrganizationService;
import io.orten.nano.model.Organization;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class OrganizationAPI {
    public static List<Organization> o_list = new ArrayList<Organization>();

    @GET
    @Path("/get/organization/{organizationID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganization(@PathParam("organizationID") String organizationID) {
        try {
            Organization organization = OrganizationService.getOrganization(organizationID);
            return Response.status(200).entity(organization).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/get/organizations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizations() {
        try {
            List<Organization> organizations = OrganizationService.getOrganizations();
            return Response.status(200).entity(organizations).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/get/organizations/{organizationName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizationsByName(@PathParam("organizationName") String organizationName) {
        try {
            List<Organization> organizations = OrganizationService.getOrganizationsByName(organizationName);
            return Response.status(200).entity(organizations).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/post/organization")
    public Response saveOrganization(Organization organization) {
        try {
            OrganizationService.saveOrganization(organization);
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("/delete/organization/{organizationID}")
    public Response deleteOrganization(@PathParam("organizationID") String organizationID) {
        try {
            OrganizationService.deleteOrganization(organizationID);
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }
}