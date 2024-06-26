package main.java.AtomicVolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class CustomerAtomic extends Thread{
    private TicketCounterAtomic ticketCounter;
    private int quantity;
    private String name;
    public CustomerAtomic(TicketCounterAtomic ticketCounter, int quantity, String name) {
        this.name = name;
        this.ticketCounter = ticketCounter;
        this.quantity = quantity;
    }
    @Override
    public void run() {
        ticketCounter.atomicBuyTickets(quantity,name);
    }
}
