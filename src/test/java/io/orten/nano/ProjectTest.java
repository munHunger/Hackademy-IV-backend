package io.orten.nano;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectTest {

    private SessionFactory sessionFactory;
    private Session s;
    @Before
    public void before(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        MetadataSources mds = new MetadataSources(registry);
        Metadata md = mds.buildMetadata();
        sessionFactory= md.buildSessionFactory();
        s = sessionFactory.openSession();
        s.beginTransaction();
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            StandardServiceRegistryBuilder.destroy(registry);
        }));
    }

    @Test

    /*public void saveoroject()

       {
        Project pro= new Project("Pro5","Eden Foundation", null,null ,884.44, 1100, 30000, "CAJA", null, "Yahya",true, false, null, "ABD-1002");
        s.save(pro);
       }
*/
    @After
    public void after(){
        s.getTransaction().commit();
        s.close();
        sessionFactory.close();
    }
}