package lock8;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(()->{
            phone1.sendSMS();
        },"a").start();
        TimeUnit.SECONDS.sleep((2));
        new Thread(()->{
            phone2.call();
        },"b").start();

    }

}
class Phone2{
    public synchronized void sendSMS(){
        try {
            TimeUnit.SECONDS.sleep(1 );
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