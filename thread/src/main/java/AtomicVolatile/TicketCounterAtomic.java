package main.java.AtomicVolatile;

import java.util.concurrent.atomic.AtomicInteger;

class TicketCounterAtomic {

    private AtomicInteger availableTicketsAtomic;

    public TicketCounterAtomic(AtomicInteger availableTickets) {
        this.availableTicketsAtomic = availableTickets;
    }

    public void atomicBuyTickets(AtomicInteger quantity, String name) {
        if (availableTicketsAtomic.get() >= quantity.get()) {
            System.out.println(name + " mua " + quantity.get() + " vé.");
            availableTicketsAtomic.set(availableTicketsAtomic.get()-quantity.get());
        } else {
            System.out.println(name + " không thể mua vé. Số vé còn lại: " + availableTicketsAtomic.get());
        }
    }

}