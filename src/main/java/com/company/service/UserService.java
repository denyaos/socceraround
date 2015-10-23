package com.company.service;

import com.company.domain.User;
import com.company.domain.repository.AuthorityRepository;
import com.company.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Transactional
    public User findUserWithAuthorities(String username) {
        User user = userRepository.findOneByUsername(username);
        if (user != null) {
            user.getAuthorities().size();
        }
        return user;
    }
}
