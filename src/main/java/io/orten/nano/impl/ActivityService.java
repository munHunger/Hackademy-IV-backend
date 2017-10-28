package io.orten.nano.impl;

import io.orten.nano.model.Activity;
import io.orten.nano.util.Database;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class ActivityService {

       public static List<Activity> activityList = new ArrayList<Activity>();

    /**
     *
     * @param activityId
     * @return activity
     * @throws Exception
     */
    public static Activity getActivityByActivityId(long activityId) throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            Activity activity = session.get(Activity.class, activityId);
            session.close();
            return activity;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param projectId
     * @return activity
     * @throws Exception
     */
    public static List<Activity> getActivityByProjectId(long projectId) throws Exception {

        Session session = null;
        try {
            session = Database.getSession();
            Query query = session.createQuery("from Activity where projectId like :projectId");
            query.setParameter("projectId", projectId);
            List<Activity> activities = query.list();
            session.close();
            return activities;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @return list of Activities
     * @throws Exception
     */
    public static List<Activity> getListOfActivities() throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            List Activities = session.createQuery("from Activity").list();
            session.close();
            return Activities;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param activityTitle
     * @return Search Activities
     * @throws Exception
     */
    public static List getActivitiesByActivityTitle(String activityTitle) throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            Query query = session.createQuery("from Activity where activityTitle like :activityTitle");
            query.setParameter("activityTitle", "%" + activityTitle + "%");
            List<Activity> activities = query.list();
            session.close();
            return activities;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param activity
     * @throws Exception
     */
    public static void saveActivity(Activity activity) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = Database.getSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(activity);
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
     * @param activityId
     * @throws Exception
     */
    public static void deleteActivity(Long activityId) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = Database.getSession();
            tx = session.beginTransaction();
            Activity activity = session.get(Activity.class, activityId);
            session.delete(activity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }
}