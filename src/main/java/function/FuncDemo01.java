package function;

import java.util.function.Function;
//Function 传入一个参数，返回一个值
public class FuncDemo01 {
    public static void main(String[] args) {
        Function function = (str)->{
            return str;
        };
        System.out.println(function.apply("asd"));
    };
}
