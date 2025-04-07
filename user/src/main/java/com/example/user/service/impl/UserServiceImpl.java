package com.example.user.service.impl;

import com.example.user.entity.User;
import com.example.user.service.IUserService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements IUserService {
    private final ConcurrentHashMap<Long, User> userMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public User createUser(User user) {
        user.setId(idGenerator.incrementAndGet());
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        if (userMap.containsKey(user.getId())) {
            user.setUpdateTime(LocalDateTime.now());
            userMap.put(user.getId(), user);
            return user;
        }
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }
} 