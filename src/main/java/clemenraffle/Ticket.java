package clemenraffle;

import java.util.Random;

public class Ticket {
    private String clientName;
    private int numChars;
    private String value;

    public Ticket() {
    }

    public Ticket(String clientName, int numChars, String value) {
        this.clientName = clientName;
        this.numChars = numChars;
        this.value = value;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getNumChars() {
        return numChars;
    }

    public void setNumChars(int numChars) {
        this.numChars = numChars;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String generateValue() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numChars; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "clientName='" + clientName + '\'' +
                ", numChars=" + numChars +
                ", value='" + value + '\'' +
                '}';
    }
}
