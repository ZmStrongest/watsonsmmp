package thread;

public class SellingTicket implements Runnable {
    private int ticketNum = 1000;
    private int ticketSeq = 1;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                sellingTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sellingTicket() {
        if (ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + ":正在售卖第" + ticketSeq + "张票");
            ticketNum --;
            ticketSeq ++;
        }
    }
}
