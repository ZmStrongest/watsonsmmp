package thread;

import java.util.LinkedList;
import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Integer> consumQueue;
    private int maxSize;
    private int currentSize = 0;

    public Consumer(Queue<Integer>warehouse, int maxSize){
        this.maxSize = maxSize;
        this.consumQueue = warehouse;
    }

    @Override
    public void run() {
        while (true){
            consumeBySync();
        }
    }


    public synchronized void consumeBySync(){
        if (consumQueue.size() > 0) {
            System.out.println(Thread.currentThread().getName() + ":生产一瓶牛奶");
            consumQueue.remove(1);
        }
    }

    public void consumeByLock(){

    }

    public void consumeByBlockQueue(){

    }
}
