package io.orten.nano.implementation;

import io.orten.nano.model.Organization;
import io.orten.nano.utility.DataAccess;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletResponse;


public class API {


        public Response save(Organization org)
        {
            try{
                DataAccess.saveObject(org);
                return Response.status(HttpServletResponse.SC_CREATED).build();
            }
            catch(Exception e) {
                return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
        }
    }

