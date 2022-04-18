package thread;

import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {
    private static final int MAX_SIZE = 10;

    public static void main(String[] args) {
        Queue<Integer> warehouse = new LinkedList<Integer>();

        Producer p1 = new Producer(warehouse,MAX_SIZE);
        Producer p2 = new Producer(warehouse,MAX_SIZE);
        Consumer c1 = new Consumer(warehouse,MAX_SIZE);
        Consumer c2 = new Consumer(warehouse,MAX_SIZE);
        Consumer c3 = new Consumer(warehouse,MAX_SIZE);

        Thread t1 = new Thread(p1, "生产队1");
        Thread t2 = new Thread(p2, "生产队2");
        Thread t3 = new Thread(c1, "消费者1");
        Thread t4 = new Thread(c2, "消费者2");
        Thread t5 = new Thread(c3, "消费者3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
