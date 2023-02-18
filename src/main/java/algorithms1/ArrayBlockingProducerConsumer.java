package algorithms1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingProducerConsumer {
    private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(15);

    public void producer() {
        while (true) {
            int value = (new Random()).nextInt();
            System.out.println("Inserted Value " + value);
            blockingQueue.add(value);
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            if(!blockingQueue.isEmpty()) {
                Integer take = blockingQueue.take();
                System.out.println("Took out value: " + take);
            }

        }
    }

    public static void main(String[] args) {
        ArrayBlockingProducerConsumer arrayBlockingProducerConsumer = new ArrayBlockingProducerConsumer();

        Thread producer = new Thread(arrayBlockingProducerConsumer::producer);
        Thread consumer = new Thread(() -> {
            try {
                arrayBlockingProducerConsumer.consumer();
            } catch (InterruptedException e) {
                System.out.println("Error " + e.getMessage());
            }
        });
        producer.start();
        consumer.start();
    }
}
