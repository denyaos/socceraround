package com.company.services;

import com.company.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User createDefaultUser() {
        User user = new User();
        user.setId(13879);
        user.setFirstName("John");
        user.setLastName("Lennon");
        return user;
    }
}
