package cas;

import java.util.concurrent.atomic.AtomicInteger;
//CAS:compare And Set 比较并交换
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        atomicInteger.compareAndSet(2020,2021);
        System.out.println(atomicInteger);
        atomicInteger.getAndIncrement();
    }
}
