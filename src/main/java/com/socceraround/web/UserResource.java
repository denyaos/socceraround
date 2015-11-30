package com.socceraround.web;

import com.socceraround.domain.User;
import com.socceraround.domain.dto.PlayerRegistrationModel;
import com.socceraround.domain.repository.UserRepository;
import com.socceraround.service.PlayerService;
import com.socceraround.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class UserResource {

    private UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public User getCurrentUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findOneByUsername(principal.getUsername());
    }
}
