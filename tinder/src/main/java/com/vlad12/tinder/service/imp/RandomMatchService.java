package com.vlad12.tinder.service.imp;

import com.vlad12.tinder.entity.User;
import com.vlad12.tinder.repositary.UsersRepositary;
import com.vlad12.tinder.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RandomMatchService implements MatchService {
    private UsersRepositary usersRepositary;

    @Autowired
    public RandomMatchService(UsersRepositary usersRepositary) {
        this.usersRepositary = usersRepositary;
    }

    @Override
    public User getNewMatch() {

        List<User> users = usersRepositary.getUserList();
        Random random = new Random();
        int i = random.nextInt(users.size());
        return users.get(i);
    }
}
