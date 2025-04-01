package clemenraffle;

public class Winner {
    private Ticket winningTicket;
    private boolean winnerSelected;

    public Winner() {
        this.winnerSelected = false;
    }

    public synchronized void selectWinner(Ticket ticket) {
        if (!winnerSelected) {
            this.winningTicket = ticket;
            this.winnerSelected = true;
        }
    }

    public synchronized Ticket getWinningTicket() {
        return winningTicket;
    }

    public synchronized boolean isWinnerSelected() {
        return winnerSelected;
    }
}