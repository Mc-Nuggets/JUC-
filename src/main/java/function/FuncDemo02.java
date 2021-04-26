package function;

import java.util.function.Predicate;

public class FuncDemo02 {
    public static void main(String[] args) {
        Predicate<String> objectPredicate = s -> {
            if (s.equals("")){
                return true;
            }
             return false;
        };
        System.out.println(objectPredicate.test("s"));
    }
}
