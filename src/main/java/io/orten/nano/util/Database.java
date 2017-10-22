package io.orten.nano.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Database {
    private static SessionFactory sessionFactory;
    private static void init(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        MetadataSources mds = new MetadataSources(registry);
        Metadata md = mds.buildMetadata();
        sessionFactory = md.buildSessionFactory();
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            StandardServiceRegistryBuilder.destroy(registry);
        }));
    }

        public static void saveObject(Object o){
        if(sessionFactory == null)
            init();
        try(Session s = sessionFactory.openSession()){
            s.beginTransaction();
            s.save(o);
            s.getTransaction().commit();
        }
    }

    public static void updateOrganization(Object o){
    if(sessionFactory == null)
        init();
    try(Session s = sessionFactory.openSession()){
        s.beginTransaction();
        s.update(o);
        s.getTransaction().commit();
    }
    }

    public static Session getSession() throws Exception {
        if(sessionFactory == null) {
            init();
        }
        Session session = sessionFactory.openSession();
        return session;
    }
 }