package com.example.data.rest.datarest.service;

import com.example.data.rest.datarest.exception.NotFoundException;
import com.example.data.rest.datarest.jpa.UserEntity;
import com.example.data.rest.datarest.jpa.UserJpaClient;
import com.example.data.rest.datarest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaClient userJpaClient;

    @Override
    public User getUser(int id) {
        UserEntity userEntity = userJpaClient.findById(id).orElseThrow(NotFoundException::new);
        return getUser(userEntity);
    }

    @Override
    public User getUser(String name) {
        UserEntity userEntity = userJpaClient.findByName(name).orElseThrow(NotFoundException::new);
        return getUser(userEntity);
    }

    @Override
    public User save(User user) {
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setBonusPoints(user.getBonusPoints());
        UserEntity save = userJpaClient.save(entity);
        return getUser(save);
    }

    private User getUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .bonusPoints(userEntity.getBonusPoints())
                .build();
    }
}
