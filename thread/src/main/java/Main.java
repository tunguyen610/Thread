package main.java;

class Main {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(3); // Số lượng vé ban đầu là 3

        // Tạo và khởi chạy các khách hàng mua vé
        CustomerThread customerThread1 = new CustomerThread(ticketCounter, 2, "Khách hàng 1");
        CustomerThread customerThread2 = new CustomerThread(ticketCounter, 2, "Khách hàng 2");
        CustomerRunable customerRunable1 = new CustomerRunable(ticketCounter, 2, "Khách hàng 3");
        CustomerRunable customerRunable2 = new CustomerRunable(ticketCounter, 2, "Khách hàng 4");
        customerThread1.start();
        customerThread2.start();
        customerRunable1.run();
        customerRunable2.run();
    }
}