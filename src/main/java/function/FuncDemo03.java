package function;

import java.util.function.Consumer;
import java.util.function.Supplier;

//Consumer只有输入，没有返回
public class FuncDemo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)->{
            System.out.println("1");
        };
        Supplier<String> supplier = ()->{
            return "1024";
        };
        consumer.accept("1");
        System.out.println(supplier.get());
    }
}
