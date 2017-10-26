package io.orten.nano.impl;

import io.orten.nano.model.Project;
import io.orten.nano.util.Database;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {

    public static List<Project> projectList = new ArrayList<Project>();

    /**
     *
     * @param id
     * @return project
     * @throws Exception
     */
    public static Project getprojectbyid(long id) throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            Project project = session.get(Project.class, id);
            session.close();
            return project;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param projectID
     * @return project
     * @throws Exception
     */
    public static Project getProjectByProjectId(String projectID) throws Exception {

        Session session = null;
        try {
            session = Database.getSession();
            Query query = session.createQuery("from Project where projectId like :projectID");
            query.setParameter("projectID", projectID);
            Project project = (Project) query.uniqueResult();
            session.close();
            return project;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @return list of projects
     * @throws Exception
     */
    public static List<Project> getListOfProjects() throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            List projects = session.createQuery("from Project").list();
            session.close();
            return projects;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param projectName
     * @return list of projects
     * @throws Exception
     */
    public static List getProjectsByName(String projectName) throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            Query query = session.createQuery("from Project where projectName like :projectName");
            query.setParameter("projectName", "%" + projectName + "%");
            List<Project> projects = query.list();
            session.close();
            return projects;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param project
     * @throws Exception
     */
    public static void saveProject(Project project) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = Database.getSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(project);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    public static void deleteProject(Long id) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = Database.getSession();
            tx = session.beginTransaction();
            Project project = session.get(Project.class, id);
            session.delete(project);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    //ToDO: Project and Doner has Many-to-Many relation so can not be handled as code added by Nijla
    //ToDO: Project donor need to be refactored further.

    /**
     * saves a donor information of an specific project
     * @param donor
     * @throws Exception
     */
    /*public static void fundedBy(Donor donor,String projectID) throws Exception{
        Session session = Database.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Project project = getProject(projectID);
            project.setDonor(donor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }*/
   /* public static List<Project> getFundedProjects(String donorID) throws Exception{
        List<Project> fundedProjects = new ArrayList<>();
        Session session = Database.getSession();
        Transaction tx= null;
        try{
            tx =session.beginTransaction();
            Query query = session.createQuery("from Project where donor.userID= :donorID");
            query.setParameter("donorID",donorID);
            fundedProjects=query.getResultList();
            if (!(fundedProjects.isEmpty())){
                return fundedProjects;
            } else  return null;

        }catch(HibernateException e){
            if (tx != null) tx.rollback();
            throw e;
        }finally{
            session.close();
        }
    }*/
}