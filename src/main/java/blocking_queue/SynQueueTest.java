package blocking_queue;

import java.sql.Time;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"PUT 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"PUT 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"PUT 3");
                synchronousQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+"POLL "+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+"POLL "+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+"POLL "+synchronousQueue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
