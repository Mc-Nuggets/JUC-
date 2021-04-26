package single;
//懒汉式
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"来了");
    }
    private static LazyMan LAZYMAN;
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
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }
    }
}
