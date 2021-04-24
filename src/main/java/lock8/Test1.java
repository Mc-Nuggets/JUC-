package lock8;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSMS();
        },"a").start();
        TimeUnit.SECONDS.sleep((1));
        new Thread(()->{
            phone.call();
        },"b").start();
        new Thread(()->{
            phone.hello();
        },"c").start();
    }

}
class Phone{
    public synchronized void sendSMS(){
        try {
            TimeUnit.SECONDS.sleep(3 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送sms");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
    public void hello(){
        System.out.println("hello");
    }
}