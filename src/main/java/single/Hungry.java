package single;
//饿汉式
public class Hungry {
    //可能会浪费内存空间
    public Hungry(){

    }
    public static final Hungry HUNGRY = new Hungry();
    public static Hungry getInstance(){
        return HUNGRY;
    }
}
