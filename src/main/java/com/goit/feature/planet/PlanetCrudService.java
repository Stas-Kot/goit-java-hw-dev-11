package com.goit.feature.planet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlanetCrudService {
    private Session session;

    public PlanetCrudService(Session session) {
        this.session = session;
    }

    public void create(String id, String name) {
        Planet planet = new Planet();

        boolean valid = id.matches("^[A-Z0-9]+$");

        if (valid) {
            planet.setId(id);
            planet.setName(name);
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } else {
            System.out.println("Not valid id! Please write only latins letters in upper case and/or digits");
        }
    }

    public List<Planet> getAll() {
        return session.createQuery("from Planet", Planet.class).list();
    }

    public Planet getById(String id) {
        return session.get(Planet.class, id);
    }

    public Planet updateById(String id, String newName) {
        Transaction transaction = session.beginTransaction();
        Planet existing = getById(id);
        existing.setName(newName);
        session.persist(existing);
        transaction.commit();
        return existing;
    }

    public void deleteById(String id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Planet where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        transaction.commit();
        if (result > 0) {
            System.out.println("Planet was removed");
        }

    }
}
