package com.revature.Email_API.controller;


import com.revature.Email_API.models.User;
import com.revature.Email_API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) throws URISyntaxException {
        boolean success = false;
        success = userService.addUser(user);
        return ResponseEntity.created(new URI("http://localhost/users/" + user.getUserId())).build();
    }

    @GetMapping("{userId}")
    public ResponseEntity getUsers(@PathVariable int userId) {
        Optional<User> user = userService.getByUserId(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        }return ResponseEntity.notFound().build();
    }
}
