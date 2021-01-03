package Polytech.Labaratory4.dao;

import Polytech.Labaratory4.enums.Priority;
import Polytech.Labaratory4.enums.Status;
import Polytech.Labaratory4.interfaces.Singleton;
import Polytech.Labaratory4.model.Ticket;

import java.time.LocalDate;
import java.util.*;

public class TicketInMemoryDao implements TicketDao, Singleton {

    static private TicketInMemoryDao instance;

    public static TicketInMemoryDao getInstance() {
        if (instance == null) {
            instance = new TicketInMemoryDao();
        }
        return instance;
    }

    private Map<String, Ticket> tickets = new HashMap<>();

    private TicketInMemoryDao() {
        String id1 = UUID.randomUUID().toString();
        Ticket ticket1 = new Ticket(
                id1,
                "Create app",
                "Description of the god damn task",
                new ArrayList<>(),
                "5a817bdd-8294-4b05-a8f6-dc0e631563e5",
                Status.TODO,
                Priority.MEDIUM,
                18000, // 5 hours
                5000,

                LocalDate.now());
        String id2 = UUID.randomUUID().toString();
        Ticket ticket2 = new Ticket(
                id1,
                "Create app",
                "Description of the god damn task",
                new ArrayList<>(),
                "7c2a397b-3634-426f-bf57-4a9bda5d6ede",
                Status.TODO,
                Priority.MEDIUM,
                18000, // 5 hours
                5000,

                LocalDate.now());
        String id3 = UUID.randomUUID().toString();
        Ticket ticket3 = new Ticket(
                id1,
                "Create app",
                "Description of the god damn task",
                new ArrayList<>(),
                "4d87fd3a-ae9c-4834-a166-c745a8c92cda",
                Status.TODO,
                Priority.MEDIUM,
                18000, // 5 hours
                5000,

                LocalDate.now());
        String id4 = UUID.randomUUID().toString();
        Ticket ticket4 = new Ticket(
                id1,
                "Create app",
                "Description of the god damn task",
                new ArrayList<>(),
                "9e7c6150-54f4-4f9e-a706-1412d65eb03a",
                Status.TODO,
                Priority.MEDIUM,
                18000, // 5 hours
                5000,

                LocalDate.now());
        String id5 = UUID.randomUUID().toString();
        Ticket ticket5 = new Ticket(
                id1,
                "Create app",
                "Description of the god damn task",
                new ArrayList<>(),
                "be3c0e68-d35c-4960-9c88-82f789bbcd06",
                Status.TODO,
                Priority.MEDIUM,
                18000, // 5 hours
                5000,

                LocalDate.now());


        tickets.put(id1, ticket1);
        tickets.put(id2, ticket2);
        tickets.put(id3, ticket3);
        tickets.put(id4, ticket4);
        tickets.put(id5, ticket5);
    }


    @Override
    public Ticket save(Ticket ticket) {
        return tickets.put(ticket.getTicketId(), ticket);
    }

    @Override
    public Ticket getById(String ticketId) {
        return tickets.get(ticketId);
    }

    @Override
    public boolean removeById(String ticketId) {
        tickets.remove(ticketId);
        return Boolean.parseBoolean(ticketId);

    }

    @Override
    public List<Ticket> getAllTickets() {
       return new ArrayList<>(tickets.values());
    }

    public List<Ticket> findByName(String query) {
        final List<Ticket> result = new LinkedList<>();
        for (Ticket ticket : tickets.values()) {
           if (ticket.getName().contains(query) || ticket.getDescription().contains(query))
            result.add(ticket);
        }
        return result;
    }
}
