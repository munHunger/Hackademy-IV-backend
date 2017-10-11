package io.orten.nano.business;
import io.orten.nano.util.Database;

import io.orten.nano.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")

public class ProjectAPI {

    public static List<Project> p_list = new ArrayList<Project>();

    @GET
    @Path("/get/project/{projectID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@PathParam("projectID") String projectID) {

        try {
            Session session = Database.getSession();


            Project project = session.get(Project.class, projectID);
            session.close();
            return Response.status(200).entity(project).header("authentication", "token sadjahsdlashd").build();

        } catch (Exception e) {
            return Response.status(500).build();
        }


    }


    @GET
    @Path("/get/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() {

        try {
            Session session = Database.getSession();


            List projects = session.createQuery("from Project").list();

            session.close();
            return Response.status(200).entity(projects).header("authentication", "token sadjahsdlashd").build();

        } catch (Exception e) {
            return Response.status(500).build();
        }


    }

    @GET
    @Path("/get/projects/{projectName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects(@PathParam("projectName") String projectName) {

        try {
            Session session = Database.getSession();


            Query query = session.createQuery("from Project where name like :projectName");
            query.setParameter("projectName", "%" + projectName + "%");

            List projects = query.list();
            session.close();
            return Response.status(200).entity(projects).header("authentication", "token sadjahsdlashd").build();

        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/post/project")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Project project) {
        try {
            Database.saveObject(project);
            return Response.status(204).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }


    @DELETE
    @Path("/delete/project/{projectID}")
    public Response deleteProject(@PathParam("projectID") long projectID) {

        try {
            Session session = Database.getSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Project project= session.get(Project.class, projectID);
                session.delete(project);
                tx.commit();

            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                throw e;
            } finally {
                session.close();
            }

            return Response.status(200).build();

        } catch (Exception e) {
            return Response.status(500).build();
        }


    }
}

