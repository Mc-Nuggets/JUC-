package fuzhulei;

import java.util.concurrent.CountDownLatch;

public class countDownTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+" 走了");
            }).start();
        }
        countDownLatch.await();//归零才继续执行，否则下面的语句可能是线程会先执行
        System.out.println("------走完了------");
    }
}
