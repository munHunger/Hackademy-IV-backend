package io.orten.nano.impl;

import io.orten.nano.model.Organization;
import io.orten.nano.util.Database;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class OrganizationService {

    public static List<Organization> o_list = new ArrayList<Organization>();

    public static Organization getOrganization(String organizationID) throws Exception {
        Session session = Database.getSession();
        Organization organization = session.get(Organization.class, organizationID);
        session.close();
        return organization;
    }

    public static List<Organization> getOrganizations() throws Exception {
        Session session = Database.getSession();
        List organizations = session.createQuery("from Organization").list();
        session.close();
        return organizations;
    }

    public static List getOrganizationsByName(String organizationsName) throws Exception {
        Session session = Database.getSession();
        Query query = session.createQuery("from Organization where name like :organizationsName");
        query.setParameter("organizationsName", "%" + organizationsName + "%");
        List<Organization> organizations = query.list();
        session.close();
        return organizations;
    }

    public static void saveOrganization(Organization organization) throws Exception {
        Session session = Database.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(organization);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void deleteOrganization(String organizationID) throws Exception {
        Session session = Database.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Organization organization= session.get(Organization.class, organizationID);
            session.delete(organization);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}