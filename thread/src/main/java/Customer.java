package main.java;

class Customer extends Thread {
    private TicketCounter ticketCounter;
    private int quantity;

    public Customer(TicketCounter ticketCounter, int quantity, String name) {
        super(name);
        this.ticketCounter = ticketCounter;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        // Không sử dụng synchronized
        //ticketCounter.buyTickets(quantity);

        // Sử dụng synchronized
        ticketCounter.synchronizedBuyTickets(quantity);
    }
}