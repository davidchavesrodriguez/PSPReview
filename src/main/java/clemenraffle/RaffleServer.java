package clemenraffle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RaffleServer {
    public static final int MAX_TICKETS = 5;
    public static final int TICKET_LENGTH = 6;
    public static final int PORT = 55555;

    private static List<Ticket> soldTickets = new ArrayList<>();
    private static Winner winner = new Winner();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("ClemenRaffle Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                RaffleServerWorker worker = new RaffleServerWorker(clientSocket, soldTickets, winner);
                new Thread(worker).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    public static synchronized boolean canSellMoreTickets() {
        return soldTickets.size() < MAX_TICKETS;
    }

    public static synchronized void addTicket(Ticket ticket) {
        soldTickets.add(ticket);
    }

    public static synchronized int getTotalTicketsSold() {
        return soldTickets.size();
    }

    public static synchronized List<Ticket> getSoldTickets() {
        return new ArrayList<>(soldTickets);
    }
}