package clemenraffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class RaffleClient {
    private static final String SERVER_ADDRESS = "localhost";
    public static final int SERVER_PORT = 55555;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)
        ) {

            // Show welcome message
            System.out.println(in.readLine());

            while (true) {
                System.out.print("\nOptions:\n"
                        + "1. Register client (CLIENT <client-name>)\n"
                        + "2. Buy a ticket (BUY)\n"
                        + "3. Calculate odds (CALC)\n"
                        + "4. Exit program (QUIT)\n");

                String fullOption = scanner.nextLine();
                String option = fullOption.trim();

                switch (option) {
                    case "1":

                }
            }
        }
    }
}
