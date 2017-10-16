package io.orten.nano.business;

import io.orten.nano.model.Organization;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class API {

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveInDatabase(Organization org)
    {

        return new io.orten.nano.impl.API().save(org);
    }
}
