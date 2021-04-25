package blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    //有返回值，抛出异常
    public static void test1(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
    }
    //有返回值，添加对象为null时抛出异常，取不出来时返回null
    public static void test2(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));//true
        System.out.println(arrayBlockingQueue.offer("b"));//true
        System.out.println(arrayBlockingQueue.offer("c"));//true
        System.out.println(arrayBlockingQueue.offer("d"));//false
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

    }
    //等待，阻塞（一直等待）
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        System.out.println(arrayBlockingQueue.take());
        arrayBlockingQueue.put("d");
    }
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer('a',2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer('b',2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer('c',2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer('d',2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
    }
}
