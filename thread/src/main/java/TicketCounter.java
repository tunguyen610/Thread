package main.java;

class TicketCounter {
    private int availableTickets;

    public TicketCounter(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    // Phương thức mua vé không sử dụng synchronized
    public void buyTickets(int quantity) {
        if (availableTickets >= quantity) {
            System.out.println(Thread.currentThread().getName() + " mua " + quantity + " vé.");
            availableTickets -= quantity;
        } else {
            System.out.println(Thread.currentThread().getName() + " không thể mua vé. Số vé còn lại: " + availableTickets);
        }
    }

    // Phương thức mua vé sử dụng synchronized
    public synchronized void synchronizedBuyTickets(int quantity) {
        if (availableTickets >= quantity) {
            System.out.println(Thread.currentThread().getName() + " mua " + quantity + " vé.");
            availableTickets -= quantity;
        } else {
            System.out.println(Thread.currentThread().getName() + " không thể mua vé. Số vé còn lại: " + availableTickets);
        }
    }
}