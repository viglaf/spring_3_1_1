package com.vig.springboot_3_1_1.service;

import com.vig.springboot_3_1_1.entity.User;
import com.vig.springboot_3_1_1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {return userRepository.findAll();}

    @Transactional
    public void add(User user) {userRepository.save(user);}

    @Transactional
    @Override
    public void edit(User user, int id) {
        User user1 = this.getById(id);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setAge(user.getAge());
    }

    @Transactional
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public User getById(int id) {return userRepository.findById(id).orElse(null);}

}