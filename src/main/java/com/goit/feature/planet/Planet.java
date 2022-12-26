package com.goit.feature.planet;

import com.goit.feature.ticket.Ticket;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    private String id;

    @Column(nullable = false, length = 200)
    private String name;

    @OneToMany(mappedBy = "from")
    private List<Ticket> fromTickets;

    @OneToMany(mappedBy = "to")
    private List<Ticket> toTickets;
}
