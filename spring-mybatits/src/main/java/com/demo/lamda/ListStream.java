package com.demo.lamda;

import com.demo.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListStream {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        User user1 = new User(1, "张三24", 24);
        User user2 = new User(2, "李四27", 27);
        User user3 = new User(3, "王五21", 21);
        User user4 = new User(4, "张三22", 22);
        User user5 = new User(5, "李四20", 20);
        User user6 = new User(6, "王五28", 28);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);

        List<String>  ages=userList.stream().sorted(Comparator.comparing(User::getAge)).map(user -> user.getName()).collect(Collectors.toList());
        for (String name:ages  ) {
            System.out.println(name);
        }
        Map<String,Integer> userMap = userList.stream().collect(Collectors.toMap(User::getName, User::getAge));

        for (Map.Entry<String,Integer> user :userMap.entrySet()){
            System.out.println(user.getKey()+":"+user.getValue());
        }

    }
}
