package com.vlad12.tinder.repositary;

import com.vlad12.tinder.entity.Sex;
import com.vlad12.tinder.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersRepositaryImpl implements UsersRepositary {
    private List<User> userList;
    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("Vlad");
        user.setSex(Sex.MALE);
        user.setPoint(10);

        User user2 = new User();
        user.setName("Alex");
        user.setSex(Sex.MALE);
        user.setPoint(20);

        User user3 = new User();
        user.setName("Andrey");
        user.setSex(Sex.MALE);
        user.setPoint(15);

        userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user2);
    }

    public List<User> getUserList(){
        return userList;
    }
}
