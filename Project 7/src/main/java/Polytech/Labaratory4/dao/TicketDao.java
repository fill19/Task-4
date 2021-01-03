package Polytech.Labaratory4.dao;

import Polytech.Labaratory4.model.Ticket;

import java.util.List;

public interface TicketDao {

    Ticket save(Ticket ticket);

    Ticket getById(String tickedId);

    boolean removeById(String tickedId);

    List<Ticket> getAllTickets();

}
