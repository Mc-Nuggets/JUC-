package stream;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User u1 = new User(1,"a",1);
        User u2 = new User(2,"b",12);
        User u3 = new User(3,"c",15);
        User u4 = new User(4,"d",21);
        List<User> list = Arrays.asList(u1,u2,u3,u4);
        list.stream().filter(u->{
            return u.getId()%2==0;
        }).filter(user -> {
            return user.getAge()>12;
        }).map(user -> {
            return user.getName().toUpperCase();
        }).forEach((user) -> {
            System.out.println(user);
        });
    }
}
