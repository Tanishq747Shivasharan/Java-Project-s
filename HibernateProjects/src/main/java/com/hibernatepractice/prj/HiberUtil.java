package com.hibernatepractice.prj;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtil {
    private static final SessionFactory sf = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

/*
 * HiberUtil: This is a utility class responsible for managing the Hibernate
 * SessionFactory. It centralizes the initialization, access, and shutdown of
 * Hibernate's session management for the application.
 * 
 * private static final SessionFactory sessionFactory = buildSessionFactory();
 * Purpose: Defines a static SessionFactory instance that is initialized once
 * when the class is loaded. This object is used throughout the application to
 * create Session objects for interacting with the database.
 * Why Static: It's static because SessionFactory is intended to be a shared
 * resource across the application, and it should only be instantiated once.
 * 
 * private static SessionFactory buildSessionFactory() {
 * Purpose: Declares a private static method responsible for constructing and
 * configuring the SessionFactory.
 * 
 * return new Configuration().configure().buildSessionFactory();
 * Purpose: This line loads the Hibernate configuration file
 * (hibernate.cfg.xml), configures Hibernate based on the settings, and then
 * creates and returns the SessionFactory.
 * Explanation: Configuration().configure() reads the default Hibernate
 * configuration, and buildSessionFactory() generates the SessionFactory
 * instance.
 * 
 * } catch (Throwable ex) {
 * Purpose: Begins a catch block to handle any errors that might occur during
 * the creation of the SessionFactory. Throwable is used to catch any type of
 * error (not just exceptions), including Error objects.
 * 
 * throw new ExceptionInInitializerError(ex);
 * Purpose: If an error occurs while building the SessionFactory, this line
 * throws a ExceptionInInitializerError. This stops the application
 * initialization process and signals a fatal error, preventing the application
 * from running with an improperly initialized Hibernate setup.
 * 
 * public static SessionFactory getSessionFactory() {
 * Purpose: Defines a public static method that allows other classes to access
 * the SessionFactory. Since SessionFactory is meant to be a singleton, this
 * method provides access to the single instance created earlier.
 * 
 * return sf;
 * Purpose: Returns the SessionFactory instance so other parts of the
 * application can use it to create Session objects for database interactions.
 * 
 * public static void shutdown() {
 * Purpose: Defines a method that shuts down Hibernate by closing the
 * SessionFactory. This is important to release resources properly when the
 * application stops.
 * getSessionFactory().close();
 * Purpose: This line calls the getSessionFactory() method to retrieve the
 * SessionFactory instance and then closes it. Closing the SessionFactory
 * ensures all resources are freed, including database connections and session
 * caches.
 */