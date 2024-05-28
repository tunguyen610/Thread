package main.java.SerialMultiThread;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SerializeExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        List<Person> personArrayList = new CopyOnWriteArrayList<>();
        personArrayList.add(new Person("John Doe", 30));
        personArrayList.add(new Person("Tommy", 40));
        personArrayList.add(new Person("Arthur", 50));
        AtomicInteger n = new AtomicInteger(1000);

        Thread serializationThread = new Thread(() -> {
            try {
                while (n.get() > 0) {
                    serializePerson(personArrayList);
                    Thread.sleep(10);
                    n.getAndDecrement();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread modificationThread = new Thread(() -> {
            try {
                while (n.get() > 0) {
                    personArrayList.add(new Person("hehe"+ new Random().nextInt(100), 70));
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
        System.out.println(deserializeList("person.ser").toString());

        // Luồng chính **không** cập nhật giá trị age
    }

    private static void serializePerson(List<Person> persons) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(persons);
        }
    }
    private static List<String> deserializeList(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<String>) in.readObject();
        }
    }

}