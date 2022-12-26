package com.goit.feature.ticket;

import com.goit.feature.client.Client;
import com.goit.feature.client.ClientCrudService;
import com.goit.feature.planet.Planet;
import com.goit.feature.planet.PlanetCrudService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class TicketCrudService {
    private final Session session;

    public TicketCrudService(Session session) {
        this.session = session;
    }

    public long create(Client client, Planet from, Planet to) {
        if(client != null && from != null && to != null) {
            Client clientExist = new ClientCrudService(session).getById(client.getId());
            PlanetCrudService planetCrudService = new PlanetCrudService(session);
            Planet fromExist = planetCrudService.getById(from.getId());
            Planet toExists = planetCrudService.getById(to.getId());
            if(clientExist != null && fromExist != null && toExists != null) {
                if(!from.equals(to)) {
                    Ticket ticket = new Ticket();

                    Transaction transaction = session.beginTransaction();
                    ticket.setClient(client);
                    ticket.setFrom(from);
                    ticket.setTo(to);
                    session.persist(ticket);
                    transaction.commit();

                    return ticket.getId();
                } else {
                    System.out.println("Departure planet and arrival planet must be different!");
                    return -1;
                }
            }
        }
        System.out.println("Client or/and Planet not exist");
        return -1;
    }

    public List<Ticket> getAll() {
        return session.createQuery("from Ticket", Ticket.class).list();
    }


    public Ticket getById(long id) {
        return session.get(Ticket.class, id);
    }

    public Ticket updateToById(long id, Planet to) {
        Transaction transaction = session.beginTransaction();
        Ticket existing = getById(id);
        existing.setTo(to);
        session.persist(existing);
        transaction.commit();
        return existing;
    }

    public Ticket updateFromById(long id, Planet from) {
        Transaction transaction = session.beginTransaction();
        Ticket existing = getById(id);
        existing.setFrom(from);
        session.persist(existing);
        transaction.commit();
        return existing;
    }

    public Ticket updateClientById(long id, Client client) {
        Transaction transaction = session.beginTransaction();
        Ticket existing = getById(id);
        existing.setClient(client);
        session.persist(existing);
        transaction.commit();
        return existing;
    }

    public void deleteById(long id) {
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("delete from Ticket where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        transaction.commit();
        if (result > 0) {
            System.out.println("Ticket was removed");
        }
    }
}
