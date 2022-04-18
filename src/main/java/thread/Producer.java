package thread;

import java.util.LinkedList;
import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Integer> produceQueue;
    private int maxSize;
    private int current = 0;

    public Producer(Queue<Integer> warehouse, int maxSize) {
        this.maxSize = maxSize;
        this.produceQueue = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            produceBySync();
        }
    }

    public synchronized void produceBySync() {
        if (produceQueue.size() <= 0) {
            System.out.println(Thread.currentThread().getName() + ":生产一瓶牛奶");
            current++;
        }
    }

    public void produceByLock() {

    }

    public void produceByBlockQueue() {

    }
}
