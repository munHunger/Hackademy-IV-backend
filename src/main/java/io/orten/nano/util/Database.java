package io.orten.nano.util;

import io.orten.nano.model.Organization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

<<<<<<< HEAD:src/main/java/io/orten/nano/util/Database.java
import java.util.List;

//  Creates and manages connections with and transactions to the database

public class Database {

    //
=======
public class Database {
>>>>>>> 29c96cb48b0cbdf93f00a1ff224dfdf2571e83a4:src/main/java/io/orten/nano/util/Database.java

        private static SessionFactory sessionFactory;
        private static void init(){
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
                    .build();
            MetadataSources mds = new MetadataSources(registry);
            Metadata md = mds.buildMetadata();
            sessionFactory = md.buildSessionFactory();
            //Make sure that the service registry is destroyed on shutdown by adding a shutdown hook to the runtime
            Runtime.getRuntime().addShutdownHook(new Thread(() ->
            {
                StandardServiceRegistryBuilder.destroy(registry);
            }));
        }

    //saving an organization object to the database

        public static void saveObject(Object o){
            if(sessionFactory == null)
                init();
            try(Session s = sessionFactory.openSession()){
                s.beginTransaction();
                s.save(o);
                s.getTransaction().commit();
            }
        }
<<<<<<< HEAD:src/main/java/io/orten/nano/util/Database.java
    //updating an organization object

        public static void updateOrganization(Object o){
            if(sessionFactory == null)
                init();
            try(Session s = sessionFactory.openSession()){
                s.beginTransaction();
                s.update(o);
                s.getTransaction().commit();
            }

        }


=======

    public static Session getSession() throws Exception {

        if(sessionFactory == null)
            init();

        Session session = sessionFactory.openSession();
        return session;


    }
>>>>>>> 29c96cb48b0cbdf93f00a1ff224dfdf2571e83a4:src/main/java/io/orten/nano/util/Database.java
    }


