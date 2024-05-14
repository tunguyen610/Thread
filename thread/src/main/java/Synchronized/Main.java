package main.java.Synchronized;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Log log = new Log();
        TicketCounter ticketCounterAtomic = new TicketCounter(10000, log);

        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(new CustomerThread(ticketCounterAtomic, 15, "Khách hàng " + (i + 1), log));
        }

        long startTime = System.nanoTime();
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Time taken Synchronized: " + duration + " nanoseconds.");
    }
}