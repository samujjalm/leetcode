package algorithms1;

public class MyThread {
    volatile int count = 0;

    private synchronized void increment() {
        count++;
    }

    void startThread() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();
    }

    void printCount() {
        System.out.println(count);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();

        thread.startThread();
        Thread.sleep(1000);
        thread.printCount();
    }
}
