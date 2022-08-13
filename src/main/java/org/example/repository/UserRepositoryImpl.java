package org.example.repository;

import org.example.Service.GeneratorUserId;
import org.example.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository{

    private final List<User> users = new ArrayList<>();
    private final GeneratorUserId generatorUserId;

    public UserRepositoryImpl(GeneratorUserId generatorUserId) {
        this.generatorUserId = generatorUserId;

        users.add(new User(generatorUserId.getId(), "admin"));
        users.add(new User(generatorUserId.getId(), "Konnov"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public long create(String name) {
        long userId = generatorUserId.getId();
        users.add(new User(userId, name));
        return userId;
    }
}
