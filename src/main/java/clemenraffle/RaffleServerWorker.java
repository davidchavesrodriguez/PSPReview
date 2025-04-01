package clemenraffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class RaffleServerWorker implements Runnable {
    private Socket clientSocket;
    private List<Ticket> soldTickets;
    private Winner winner;
    private String clientName;

    public RaffleServerWorker(Socket clientSocket, List<Ticket> soldTickets, Winner winner) {
        this.clientSocket = clientSocket;
        this.soldTickets = soldTickets;
        this.winner = winner;
        this.clientName = null;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            out.println("Welcome to ClemenRaffle!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
