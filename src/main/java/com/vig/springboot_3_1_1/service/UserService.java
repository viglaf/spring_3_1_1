package com.vig.springboot_3_1_1.service;

import com.vig.springboot_3_1_1.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
    void add(User user);
    void delete(int id);
    User getById(int id);
    public void edit(User user, int id);
}