package main.java;

class CustomerThread extends Thread {
    private TicketCounter ticketCounter;
    private int quantity;
    String name;
    public CustomerThread(TicketCounter ticketCounter, int quantity, String name) {
        this.name = name;
        this.ticketCounter = ticketCounter;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        // Không sử dụng synchronized
        //ticketCounter.buyTickets(quantity);

        // Sử dụng synchronized
        ticketCounter.synchronizedBuyTickets(quantity,name);
    }
}