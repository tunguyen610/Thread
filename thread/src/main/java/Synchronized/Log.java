package main.java.Synchronized;

public class Log {
    public synchronized void writeLog(String message) {
        System.out.println(message);
    }
}
