package single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//懒汉式
public class LazyMan {
    private static LazyMan LAZYMAN;
    private LazyMan(){
        synchronized (LazyMan.class){
            if(LAZYMAN!=null){
                throw new RuntimeException("已有LAZYMAN实例，不要试图使用反射破坏异常");
            }
        }
        System.out.println(Thread.currentThread().getName()+"来了");
    }

    //双重检测锁模式的懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if (LAZYMAN==null){
            synchronized (LazyMan.class){
                if (LAZYMAN==null){
                    LAZYMAN = new LazyMan();
                }
            }
        }
        if (LAZYMAN==null){
            LAZYMAN = new LazyMan();
        }
        return LAZYMAN;
    }
    //测试并发
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> lazyManConstructor = LazyMan.class.getDeclaredConstructor();
        lazyManConstructor.setAccessible(true);
        LazyMan lazyMan1 = lazyManConstructor.newInstance();
        LazyMan lazyMan2 = lazyManConstructor.newInstance();
        System.out.println("lazyMan2 = " + lazyMan2);
        System.out.println("lazyMan1 = " + lazyMan1);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }
    }
}
