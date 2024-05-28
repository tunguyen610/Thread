package main.java.DemoVolatile;

public class VolatileExample {

    private volatile boolean active;

    public void prepare() throws InterruptedException {
        new Thread(() -> {
            System.out.println("application preparing ...");
            sleep(3);
            active = true;
        })
                .start();
    }

    public void start() throws Exception {
        new Thread(() -> {
            while(!active);
            System.out.println("application started");
        })
                .start();
    }

    private static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileExample example = new VolatileExample();
        example.prepare();
        example.start();
        sleep(10);
    }
}