package fuzhulei;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100,
                new Thread(()->{
                    System.out.println("ok!");
                }));
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                cyclicBarrier.getNumberWaiting() ;
                System.out.println(Thread.currentThread().getName()+" 走了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
