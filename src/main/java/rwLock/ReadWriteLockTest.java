package rwLock;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        MyCacheLock myCacheLock = new MyCacheLock();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(()->{
                myCacheLock.put(temp+"",temp);
            },String.valueOf(temp)).start();
        }
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(()->{
                myCacheLock.get(temp+"");
            },String.valueOf(temp)).start();
        }
    }
}
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    //存（写）
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"开始写入key:"+key+" value:"+value);
        map.put(key,value);
        System.out.println(key+"写完了");
    }
    //取（读）
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"开始读 key");
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读key:"+key+" value:"+o+"完成");
    }
}
class MyCacheLock{
    private volatile Map<String,Object> map = new HashMap<>();
    //读写锁，更加细粒度的控制
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //存（写），写入的时候只希望同时只有一个线程往里面写
    public void put(String key,Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始写入key:"+key+" value:"+value);
            map.put(key,value);
            System.out.println(key+"写完了");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }
    //取（读）
    public void get(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始读 key");
            Object o = map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}