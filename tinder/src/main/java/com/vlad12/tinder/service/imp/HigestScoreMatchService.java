package com.vlad12.tinder.service.imp;

import com.vlad12.tinder.entity.User;
import com.vlad12.tinder.repositary.UsersRepositary;
import com.vlad12.tinder.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class HigestScoreMatchService implements MatchService {

    private UsersRepositary usersRepositary;
    @Autowired

    public HigestScoreMatchService(UsersRepositary usersRepositary) {
        this.usersRepositary = usersRepositary;
    }

    @Override
    public User getNewMatch() {
        List<User> users = usersRepositary.getUserList();
        int maxPoint = 0;
        User highestRangUser = null;

        for (User user : users) {
            if (user.getPoint() > maxPoint) {
                maxPoint = user.getPoint();
                highestRangUser = user;
            }
        }

        return highestRangUser;
    }


}
