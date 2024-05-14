package main.java.AtomicVolatile;

import java.util.concurrent.atomic.AtomicInteger;

class TicketCounterAtomic {

    private AtomicInteger availableTicketsAtomic;

    public TicketCounterAtomic(int totalTickets) {
        this.availableTicketsAtomic = new AtomicInteger(totalTickets);
    }

    public void atomicBuyTickets(int quantity, String name) {
        int currentTickets = availableTicketsAtomic.get();
        if (currentTickets < quantity) {
            System.out.println(name + " không thể mua vé. Số vé còn lại: " + currentTickets);
            return;
        }
        if (availableTicketsAtomic.compareAndSet(currentTickets, currentTickets - quantity)) {
            System.out.println(name + " mua " + quantity + " vé.");
        }
    }
}