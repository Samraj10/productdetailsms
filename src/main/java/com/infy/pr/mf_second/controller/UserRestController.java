package com.infy.pr.mf_second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.infy.pr.mf_second.model.User;
import com.infy.pr.mf_second.service.UserService;

@RestController
@RequestMapping("/api/susers")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void processUser(@RequestBody User user) {
        userService.processUser(user);
    }
}
