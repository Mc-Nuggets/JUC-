package lock8;

import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

        new Thread(()->{
            phone1.sendSMS();
        },"a").start();
        TimeUnit.SECONDS.sleep((2));
        new Thread(()->{
            phone2.call();
        },"b").start();

    }

}
class Phone4{
    public static synchronized void sendSMS(){
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