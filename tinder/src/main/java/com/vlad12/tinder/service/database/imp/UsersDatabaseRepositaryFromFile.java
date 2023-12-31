package com.vlad12.tinder.service.database.imp;

import com.vlad12.tinder.entity.Sex;
import com.vlad12.tinder.entity.User;
import com.vlad12.tinder.service.UsersDatabaseRepositary;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Primary
@Component
public class UsersDatabaseRepositaryFromFile implements UsersDatabaseRepositary {
    private List<User> userList;

    @PostConstruct
    public void init() throws IOException {
        String path = "users.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            User user = new User();
            String name = scanner.next();
            if (scanner.nextBoolean()) {
                user.setSex(Sex.MALE);
            }
            else {
                user.setSex(Sex.FEMALE);
            }
            int point = scanner.nextInt();
            user.setName(name);
            user.setPoint(point);
            userList = new ArrayList<>();
            userList.add(user);

        }

    }

    public List<User> getUserList(){
        return userList;
    }
}
