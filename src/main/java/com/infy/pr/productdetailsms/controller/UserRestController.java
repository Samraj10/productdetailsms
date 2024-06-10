package com.infy.pr.productdetailsms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infy.pr.productdetailsms.model.User;
import com.infy.pr.productdetailsms.service.UserService;

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
