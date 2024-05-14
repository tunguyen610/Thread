package main.java.Synchronized;

class TicketCounter {
    private volatile int availableTickets;
    private Log log;
    public TicketCounter(int availableTickets, Log log) {
        this.availableTickets = availableTickets;
        this.log = log;
    }

    // Phương thức mua vé không sử dụng synchronized
    public void buyTickets(int quantity, String name) {
        if (availableTickets >= quantity) {
            System.out.println(name + " mua " + quantity + " vé.");
            availableTickets -= quantity;
        } else {
            log.writeLog(name + " không thể mua vé. Số vé còn lại: " + availableTickets);
        }
    }

    // Phương thức mua vé sử dụng synchronized
    public synchronized void synchronizedBuyTickets(int quantity,String name) {
        if (availableTickets >= quantity) {
            System.out.println(name + " mua " + quantity + " vé.");
            availableTickets -= quantity;
        } else {
            log.writeLog(name + " không thể mua vé. Số vé còn lại: " + availableTickets);
        }
    }

    public int getTotalTickets() {
        return availableTickets;
    }

    public synchronized void logTicketStatus() {
        log.writeLog("Số vé còn lại: " + availableTickets);
    }
}