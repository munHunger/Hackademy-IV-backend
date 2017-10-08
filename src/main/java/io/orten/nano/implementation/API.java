package io.orten.nano.implementation;

import io.orten.nano.model.Organization;
import io.orten.nano.utility.DataAccess;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;


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

