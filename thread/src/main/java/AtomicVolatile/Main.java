package main.java.AtomicVolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TicketCounterAtomic ticketCounterAtomic = new TicketCounterAtomic(10000);

        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(new CustomerAtomic(ticketCounterAtomic, 15, "Khách hàng " + (i + 1)));
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

        System.out.println("Time taken Atomic: " + duration + " nanoseconds.");
    }
}
