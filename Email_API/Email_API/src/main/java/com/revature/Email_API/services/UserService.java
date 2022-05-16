package com.revature.Email_API.services;


import com.revature.Email_API.models.User;
import com.revature.Email_API.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    public boolean addUser(User user) {
        userRepo.save(user);
        return true;
    }

    public Optional<User> getByUserId(int userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            return user;
        } return null;
    }
}

