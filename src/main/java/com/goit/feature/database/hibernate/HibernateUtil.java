package com.goit.feature.database.hibernate;

import com.goit.feature.client.Client;
import com.goit.feature.planet.Planet;
import com.goit.feature.prefs.Prefs;
import com.goit.feature.ticket.Ticket;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .setProperty("hibernate.connection.url", new Prefs().getPref(Prefs.DB_JDBC_CONNECTION_URL)+";TRACE_LEVEL_SYSTEM_OUT=3")
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
