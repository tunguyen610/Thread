package main.java.AtomicVolatile;

import java.util.concurrent.atomic.AtomicInteger;

class TicketCounterVolatile {
    private volatile int availableTicketsVolatile;

    public TicketCounterVolatile(int availableTickets) {
        this.availableTicketsVolatile = availableTickets;
    }


    public void volatileBuyTickets(int quantity,String name) {
        if (availableTicketsVolatile >= quantity) {
            System.out.println(name + " mua " + quantity + " vé.");
            availableTicketsVolatile -= quantity;
        } else {
            System.out.println(name + " không thể mua vé. Số vé còn lại: " + availableTicketsVolatile);
        }
    }
}