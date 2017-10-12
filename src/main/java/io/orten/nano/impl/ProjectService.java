package io.orten.nano.impl;

import io.orten.nano.model.Project;
import io.orten.nano.util.Database;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {

    public static List<Project> p_list = new ArrayList<Project>();

    public static Project getProject(String projectID) throws Exception {

        Session session = Database.getSession();
        Project project = session.get(Project.class, projectID);
        session.close();
        return project;
    }


}

