package main.java.Synchronized;

public class CustomerRunable implements Runnable{
    private TicketCounter ticketCounter;
    private int quantity;
    private String name;
    public CustomerRunable(TicketCounter ticketCounter, int quantity, String name) {
        this.name = name;
        this.ticketCounter = ticketCounter;
        this.quantity = quantity;
    }
    @Override
    public void run() {
        ticketCounter.synchronizedBuyTickets(quantity,name);
    }
}
