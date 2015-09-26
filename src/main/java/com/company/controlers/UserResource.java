package com.company.controlers;

import com.company.entities.User;
import com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public User main() {
        return userService.createDefaultUser();
    }
}
