package volatileTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//volatile不保证原子性
public class JMMTest2 {
//    private volatile static int num = 0;
    //原子类的Integer
    private volatile static AtomicInteger num = new AtomicInteger(0);
    public static void add(){
        num.getAndIncrement();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(num.toString());
    }
}
