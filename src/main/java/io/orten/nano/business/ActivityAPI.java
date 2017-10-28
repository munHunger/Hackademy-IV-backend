package io.orten.nano.business;

import io.orten.nano.impl.ActivityService;
import io.orten.nano.model.Activity;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class ActivityAPI {

        public static List<Activity> activityList = new ArrayList<Activity>();

        @GET
        @Path("/getactivitybyactivityid/{activityId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getActivityByActivityId(@PathParam("activityId") Long activityId) {
            try {
                Activity activity = ActivityService.getActivityByActivityId(activityId);
                return Response.status(HttpServletResponse.SC_OK).entity(activity).build();
            } catch (Exception e) {
                return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
            }
        }

        @GET
        @Path("/getlistofactivitiesbyprojectid/{projectID}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getActivityByProjectId(@PathParam("projectID") long projectID) {
            try {
                List<Activity> activities = ActivityService.getActivityByProjectId(projectID);
                return Response.status(HttpServletResponse.SC_OK).entity(activities).build();
            } catch (Exception e) {
                return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
            }
        }

        @GET
        @Path("/getlistofactivities")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getListOfActivities() {
            try {
                List<Activity> activities = ActivityService.getListOfActivities();
                return Response.status(HttpServletResponse.SC_OK).entity(activities).build();
            } catch (Exception e) {
                return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
            }
        }

        @GET
        @Path("/getlistofactivitiesbyactivitytitle/{activityTitle}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getActivitiesByActivityTitle(@PathParam("activityTitle") String activityTitle) {
            try {
                List<Activity> activities = ActivityService.getActivitiesByActivityTitle(activityTitle);
                return Response.status(HttpServletResponse.SC_OK).entity(activities).build();
            } catch (Exception e) {
                return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
            }
        }

        @POST
        @Path("/saveupdateactivity")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response saveActivity(Activity activity) {
            try {
                ActivityService.saveActivity(activity);
                return Response.status(HttpServletResponse.SC_OK).build();
            } catch (Exception e) {
                return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
            }
        }

        @DELETE
        @Path("/deletebyactivityId/{activityId}")
        public Response deleteActivity(@PathParam("activityId") Long activityId) {
            try {
                ActivityService.deleteActivity(activityId);
                return Response.status(HttpServletResponse.SC_OK).build();
            } catch (Exception e) {
                return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
            }
        }
}