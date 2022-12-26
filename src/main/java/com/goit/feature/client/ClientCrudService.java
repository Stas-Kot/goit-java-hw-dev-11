package com.goit.feature.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class ClientCrudService {
    private final Session session;

    public ClientCrudService(Session session) {
        this.session = session;
    }

    public long create(String name) {
        Client client = new Client();
        if (name.length() < 2) {
            System.out.println("Incorrect name - too short, try another one!");
        } else if (name.length() > 500) {
            System.out.println("Incorrect name - too long, try another one!");
        } else {
            Transaction transaction = session.beginTransaction();
            client.setName(name);
            session.persist(client);
            transaction.commit();
        }
        return client.getId();
    }

    public List<Client> getAll() {
        return session.createQuery("from Client", Client.class).list();
    }

    public Client getById(long id) {
        return session.get(Client.class, id);
    }

    public Client updateById(long id, String newName) {
        Transaction transaction = session.beginTransaction();
        Client existing = getById(id);
        existing.setName(newName);
        session.persist(existing);
        transaction.commit();
        return existing;
    }

    public void deleteById(long id) {
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("delete from Client where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        transaction.commit();
        if (result > 0) {
            System.out.println("Client was removed");
        }
    }
}
