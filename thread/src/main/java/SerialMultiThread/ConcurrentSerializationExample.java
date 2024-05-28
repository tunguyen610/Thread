package main.java.SerialMultiThread;

import java.io.*;
import java.util.*;

public class ConcurrentSerializationExample {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");

        // Thread that serializes the list
        Thread serializationThread = new Thread(() -> {
            try {
                while (true) {
                    serializeList(list);
                    Thread.sleep(10);
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        });

        // Thread that modifies the list
        Thread modificationThread = new Thread(() -> {
            try {
                while (true) {
                    list.add("new item " + new Random().nextInt(100));
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        serializationThread.start();
        modificationThread.start();

        serializationThread.join();
        modificationThread.join();
        readFileList();
    }

    private static void serializeList(List<String> list) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.ser"))) {
            out.writeObject(list);
        }
    }
    private static void readFileList() throws IOException, ClassNotFoundException {
        // Mở file person.dat
        FileInputStream fis = new FileInputStream("person.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Đọc đối tượng Person từ file
        Person deserializedPerson = (Person) ois.readObject();

        // Đóng file
        ois.close();

        // In ra thông tin của đối tượng Person đã deserialize
        System.out.println("Name: " + deserializedPerson.getName());
        System.out.println("Age: " + deserializedPerson.getAge());
    }

}
