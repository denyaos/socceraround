package com.company;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by denis on 9/22/15.
 */
@RestController
public class Controller {

    @RequestMapping("/")
    public User main() {
        return createDefaultUser();
    }

    private User createDefaultUser() {
        User user = new User();
        user.setId(13879);
        user.setFirstName("John");
        user.setLastName("Lennon");
        return user;
    }
}
