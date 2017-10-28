package io.orten.nano.business;

import io.orten.nano.impl.ProjectService;
import io.orten.nano.model.Project;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class ProjectAPI{
    public static List<Project> projectList = new ArrayList<Project>();

    @GET
    @Path("/getprojectbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getprojectbyid(@PathParam("id") Long id) {
        try {
            Project project = ProjectService.getprojectbyid(id);
            return Response.status(HttpServletResponse.SC_OK).entity(project).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getprojectbyprojectnumber/{projectNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectByProjectId(@PathParam("projectNumber") String projectNumber) {
        try {
            Project project = ProjectService.getProjectByProjectId(projectNumber);
            return Response.status(HttpServletResponse.SC_OK).entity(project).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getlistofprojects")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListOfProjects() {
        try {
            List<Project> projects = ProjectService.getListOfProjects();
            return Response.status(HttpServletResponse.SC_OK).entity(projects).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getlistofprojectsbyname/{projectName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectsByName(@PathParam("projectName") String projectName) {
        try {
            List<Project> projects = ProjectService.getProjectsByName(projectName);
            return Response.status(HttpServletResponse.SC_OK).entity(projects).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/saveproject")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveProject(Project project) {
        try {
            ProjectService.saveProject(project);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/deleteproject/{id}")
    public Response deleteProject(@PathParam("id") Long id) {
        try {
            ProjectService.deleteProject(id);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }
}