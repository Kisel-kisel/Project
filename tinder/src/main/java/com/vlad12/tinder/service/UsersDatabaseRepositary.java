package com.vlad12.tinder.service;

import com.vlad12.tinder.entity.User;

import java.util.List;

public interface UsersDatabaseRepositary {
    public List<User> getUserList();
}
