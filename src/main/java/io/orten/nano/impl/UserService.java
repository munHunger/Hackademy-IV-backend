package io.orten.nano.impl;

import io.orten.nano.model.User;
import io.orten.nano.util.Database;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserService {

        public static List<User> u_list = new ArrayList<User>();

        public static User getUser(long userID) throws Exception {
            Session session = Database.getSession();
            User user = session.get(User.class, userID);
            session.close();
            return user;
        }

        public static List<User> getUsers() throws Exception {
            Session session = Database.getSession();
            List users = session.createQuery("from User").list();
            session.close();
            return users;
        }

        public static List getUsersByName(String userName) throws Exception {
            Session session = Database.getSession();
            Query query = session.createQuery("from User where userName like :userName");
            query.setParameter("userName", "%" + userName + "%");
            List<User> users = query.list();
            session.close();
            return users;
        }

        public static void saveUser(User user) throws Exception {
            Session session = Database.getSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(user);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                throw e;
            } finally {
                session.close();
            }
        }

        public static void deleteUser(String userID) throws Exception {
            Session session = Database.getSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                User user= session.get(User.class, userID);
                session.delete(user);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                throw e;
            } finally {
                session.close();
            }
        }
}
