package pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();//单个线程
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);//规定大小的线程池
        ExecutorService executorService2 = Executors.newCachedThreadPool();//可伸缩的

        try {
            for (int i = 0; i < 100; i++) {
                int finalI = i;
                executorService2.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService2.shutdown();
        }

    }
}
