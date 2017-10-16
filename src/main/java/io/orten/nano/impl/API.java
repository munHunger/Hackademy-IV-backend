package io.orten.nano.impl;

import io.orten.nano.model.Organization;
import io.orten.nano.util.Database;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;


public class API {


        public Response save(Organization org)
        {
            try{
                Database.saveObject(org);
                return Response.status(HttpServletResponse.SC_CREATED).build();
            }
            catch(Exception e) {
                return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
        }

    }

