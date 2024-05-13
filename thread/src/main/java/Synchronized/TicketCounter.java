package main.java.Synchronized;

class TicketCounter {
    private int availableTickets;

    public TicketCounter(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    // Phương thức mua vé không sử dụng synchronized
    public void buyTickets(int quantity, String name) {
        if (availableTickets >= quantity) {
            System.out.println(name + " mua " + quantity + " vé.");
            availableTickets -= quantity;
        } else {
            System.out.println(name + " không thể mua vé. Số vé còn lại: " + availableTickets);
        }
    }

    // Phương thức mua vé sử dụng synchronized
    public synchronized void synchronizedBuyTickets(int quantity,String name) {
        if (availableTickets >= quantity) {
            System.out.println(name + " mua " + quantity + " vé.");
            availableTickets -= quantity;
        } else {
            System.out.println(name + " không thể mua vé. Số vé còn lại: " + availableTickets);
        }
    }
}