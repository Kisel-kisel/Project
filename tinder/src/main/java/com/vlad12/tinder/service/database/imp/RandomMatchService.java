package com.vlad12.tinder.service.database.imp;

import com.vlad12.tinder.entity.User;
import com.vlad12.tinder.service.UsersDatabaseRepositary;
import com.vlad12.tinder.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RandomMatchService implements MatchService {
    private UsersDatabaseRepositary usersDatabaseRepositary;

    @Autowired
    public RandomMatchService(UsersDatabaseRepositary usersDatabaseRepositary) {
        this.usersDatabaseRepositary = usersDatabaseRepositary;
    }

    @Override
    public User getNewMatch() {

        List<User> users = usersDatabaseRepositary.getUserList();
        Random random = new Random();
        int i = random.nextInt(users.size());
        return users.get(i);
    }
}
