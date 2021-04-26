package volatileTest;

import java.util.concurrent.TimeUnit;
//volatile 保证可见性，不保证原子性
public class JMMTest {
    private volatile static int num = 0;

    public static void main(String[] args) {

        new Thread(()->{
            while(num==0){
//            num++;
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        num = 1;
        System.out.println(num);
    }
}
