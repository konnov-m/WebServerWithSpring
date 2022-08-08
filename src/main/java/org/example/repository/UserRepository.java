package org.example.repository;

import org.example.models.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    long create(String name);
}
