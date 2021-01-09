package com.example.data.rest.datarest.service;

import com.example.data.rest.datarest.pojo.User;

public interface UserService {
    User getUser(int id);

    User getUser(String name);

    User save(User user);
}
