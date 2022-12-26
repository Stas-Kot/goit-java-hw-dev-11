package com.goit.feature.ticket;

import com.goit.feature.client.Client;
import com.goit.feature.planet.Planet;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet from;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet to;
}
