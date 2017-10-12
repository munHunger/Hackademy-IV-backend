package io.orten.nano;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class API{
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response testGet()
    {
        return Response.ok("Test").build();
    }
}
