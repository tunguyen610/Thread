package main.java;

class Main {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(3); // Số lượng vé ban đầu là 3

        // Tạo và khởi chạy các khách hàng mua vé
        Customer customer1 = new Customer(ticketCounter, 2, "Khách hàng 1");
        Customer customer2 = new Customer(ticketCounter, 2, "Khách hàng 2");

        customer1.start();
        customer2.start();
    }
}