package main.java.Synchronized;

class CustomerThread extends Thread {

    private Log log;
    private TicketCounter ticketCounter;
    private int quantity;
    String name;

    public CustomerThread(TicketCounter ticketCounter, int quantity, String name, Log log) {
        this.name = name;
        this.ticketCounter = ticketCounter;
        this.quantity = quantity;
        this.log = log;
    }

    @Override
    public void run() {
        // Không sử dụng synchronized
        //ticketCounter.buyTickets(quantity, name);

        // Sử dụng synchronized
        //ticketCounter.synchronizedBuyTickets(quantity,name);

        // Deadlock
         synchronized (log) {
            log.writeLog(Thread.currentThread().getName() + " : " + name + " Bắt đầu mua vé");
            ticketCounter.synchronizedBuyTickets(quantity,name);
        }
         synchronized (ticketCounter) {
             System.out.println("đã lock log");
            ticketCounter.logTicketStatus();
        }
    }
}