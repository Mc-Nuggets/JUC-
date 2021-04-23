package test;

public class Demo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"b").start();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"c").start();
    }

}

class Ticket{
    private int number = 50;
    public synchronized void sale(){
        if(number>0)
            System.out.println(Thread.currentThread().getName()+"卖票了！:"+number--);
    }
}