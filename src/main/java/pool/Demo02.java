package pool;

import java.util.concurrent.*;

public class Demo02 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                5,
                2, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),
                /*new ThreadPoolExecutor.AbortPolicy() 不能处理时抛出异常*/
                /*new ThreadPoolExecutor.CallerRunsPolicy() 不能处理时由调用线程池的线程处理（原路返回）*/
                /*new ThreadPoolExecutor.DiscardOldestPolicy() （线程多的时候使用）队列满了不抛出异常，和第一个线程竞争，如果失败则丢掉线程*/
                new ThreadPoolExecutor.DiscardPolicy() /*队列满了不抛出异常，如果失败则丢掉线程*/
        );


        try {
            for (int i = 0; i < 9; i++) {
                int finalI = i;
                pool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
