package com.company.service;

import com.company.config.security.AuthorityConstants;
import com.company.domain.Authority;
import com.company.domain.User;
import com.company.domain.dto.PlayerRegistrationModel;
import com.company.domain.repository.AuthorityRepository;
import com.company.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

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

    public User registerUser(PlayerRegistrationModel model) {

        User user = new User();
        user.setUsername(model.getUsername());
        user.setPassword(model.getPassword());
        user.setEnabled(true);

        Authority playerAuthority = authorityRepository.findOneByName(AuthorityConstants.PLAYER);
        user.setAuthorities(Arrays.asList(playerAuthority));
        return userRepository.save(user);
    }
}
