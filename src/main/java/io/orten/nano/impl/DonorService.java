package io.orten.nano.impl;

import io.orten.nano.model.Donor;
import io.orten.nano.util.Database;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class DonorService {

        public static List<Donor> donorList = new ArrayList<Donor>();

        public static Donor getUser(long userID) throws Exception {
            Session session = null;
            try {
                session = Database.getSession();
                Donor donor = session.get(Donor.class, userID);
                session.close();
                return donor;
            }
            catch (HibernateException e) {
                throw e;
            } finally {
                if (session != null) session.close();
            }
        }

        public static List<Donor> getUsers() throws Exception {
            Session session = null;
            try {
                session = Database.getSession();
                List users = session.createQuery("from Donor").list();
                session.close();
                return users;
            }
            catch (HibernateException e) {
                throw e;
            }
            finally {
                if (session != null) session.close();
            }
        }

        public static List getUsersByName(String userName) throws Exception {
            Session session = null;
            try {
                session = Database.getSession();
                Query query = session.createQuery("from Donor where userName like :userName");
                query.setParameter("userName", "%" + userName + "%");
                List<Donor> donors = query.list();
                session.close();
                return donors;
            } catch (HibernateException e) {
                throw e;
            } finally {
                if (session != null) session.close();
            }
        }

        public static void saveUser(Donor donor) throws Exception {
            Session session = Database.getSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.saveOrUpdate(donor);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                throw e;
            } finally {
                if (session != null) session.close();
            }
        }

        public static void deleteUser(long userID) throws Exception {
            Session session = null;
            Transaction tx = null;
            try {
                session = Database.getSession();
                tx = session.beginTransaction();
                Donor donor = session.get(Donor.class, userID);
                session.delete(donor);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                throw e;
            } finally {
                if (session != null) session.close();
            }
        }
}