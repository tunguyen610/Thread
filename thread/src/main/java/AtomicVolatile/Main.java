package main.java.AtomicVolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Atomic
        TicketCounterAtomic ticketCounterAtomic = new TicketCounterAtomic(new AtomicInteger(3));
        // Tạo và khởi chạy các khách hàng mua vé
        CustomerAtomic customer1 = new CustomerAtomic(ticketCounterAtomic, new AtomicInteger(2), "Khách hàng 1");
        CustomerAtomic customer2 = new CustomerAtomic(ticketCounterAtomic, new AtomicInteger(2), "Khách hàng 2");

        //Volatile
        TicketCounterVolatile ticketCounter = new TicketCounterVolatile(3); // Số lượng vé ban đầu là 3
        CustomerVolatile customer3 = new CustomerVolatile(ticketCounter, 2, "Khách hàng 3");
        CustomerVolatile customer4 = new CustomerVolatile(ticketCounter, 2, "Khách hàng 4");

//        customer1.start();
//        customer2.start();
//        customer3.start();
//        customer4.start();

//        customer1.run();
//        customer2.run();
//        customer3.run();
//        customer4.run();
    }
}
