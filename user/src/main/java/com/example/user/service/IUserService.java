package com.example.user.service;

import com.example.user.entity.User;
import java.util.List;

public interface IUserService {
    User createUser(User user);
    User updateUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
} 