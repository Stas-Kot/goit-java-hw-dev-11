package com.goit.feature;

import com.goit.feature.client.Client;
import com.goit.feature.client.ClientCrudService;
import com.goit.feature.database.DatabaseInitService;
import com.goit.feature.database.hibernate.HibernateUtil;
import com.goit.feature.planet.Planet;
import com.goit.feature.planet.PlanetCrudService;
import com.goit.feature.ticket.Ticket;
import com.goit.feature.ticket.TicketCrudService;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        new DatabaseInitService().initDb();
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
//
        ClientCrudService clientCrudService = new ClientCrudService(session);
        PlanetCrudService planetCrudService = new PlanetCrudService(session);
        TicketCrudService ticketCrudService = new TicketCrudService(session);

//        long valera = clientCrudService.create("Valera");
//        System.out.println("valera = " + valera);
//        Client client = clientCrudService.updateById(11, "Valeria");
//        System.out.println("client = " + client);

//        Client client11 = clientCrudService.getById(11L);
//        System.out.println("client11 = " + client11);
//        List<Client> clientsBefore = clientCrudService.getAll();
//        System.out.println("clientsBefore = " + clientsBefore);
//
//        clientCrudService.deleteById(11);
//
        List<Client> clientsAfter = clientCrudService.getAll();
        System.out.println("clientsAfter = " + clientsAfter);

//        planetCrudService.create("NEP5", "Neptun");
//
//        Planet planet = planetCrudService.updateById("NEP5", "Neptun-5");
//        Planet nep5 = planetCrudService.getById("NEP5");
//        System.out.println("planet = " + nep5);

//        planetCrudService.deleteById("NEP5");

//        Planet jupi = planetCrudService.getById("JUPI");
//        System.out.println("jupi = " + jupi);

        List<Planet> planets = planetCrudService.getAll();
        System.out.println("planets = " + planets);

//        long newTicketId = ticketCrudService.create(client11, jupi, jupi);
//        System.out.println("newTicketId = " + newTicketId);

//        long newTicketId = ticketCrudService.create(client11, jupi, nep5);
//        System.out.println("newTicketId = " + newTicketId);

//        List<Ticket> tickets = ticketCrudService.getAll();
//        System.out.println("tickets = " + tickets);

//        ticketCrudService.deleteById(13);

//        Client client3 = clientCrudService.getById(3L);
//        ticketCrudService.updateClientById(12, client3);

//        Planet kepler452 = planetCrudService.getById("KEPLER452");
//        ticketCrudService.updateFromById(12L, kepler452);

//        Planet andro = planetCrudService.getById("ANDRO");
//        ticketCrudService.updateToById(12L, andro);

//        Ticket ticket12 = ticketCrudService.getById(12L);
//        System.out.println("ticket12client = " + ticket12.getClient());
//        System.out.println("ticket12from = " + ticket12.getFrom());
//        System.out.println("ticket12to = " + ticket12.getTo());

        session.close();
    }
}
