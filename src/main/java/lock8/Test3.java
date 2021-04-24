package lock8;

import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        new Thread(()->{
            phone1.sendSMS();
        },"a").start();
        TimeUnit.SECONDS.sleep((2));
        new Thread(()->{
            phone2.call();
        },"b").start();

    }

}
class Phone3{
    public static synchronized void sendSMS(){
        try {
            TimeUnit.SECONDS.sleep(1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送sms");
    }
    public static synchronized void call(){
        System.out.println("打电话");
    }
    public void hello(){
        System.out.println("hello");
    }
}