package main.java.AtomicVolatile;

public class CustomerVolatile extends Thread{
    private TicketCounterVolatile ticketCounter;
    private volatile int quantity;
    private String name;
    public CustomerVolatile(TicketCounterVolatile ticketCounter, int quantity, String name) {
        this.name = name;
        this.ticketCounter = ticketCounter;
        this.quantity = quantity;
    }
    @Override
    public void run() {
        ticketCounter.volatileBuyTickets(quantity,name);
    }
}
