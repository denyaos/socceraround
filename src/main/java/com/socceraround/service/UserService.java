package com.socceraround.service;

import com.socceraround.config.security.AuthorityConstants;
import com.socceraround.domain.Authority;
import com.socceraround.domain.User;
import com.socceraround.domain.dto.PlayerRegistrationModel;
import com.socceraround.domain.repository.AuthorityRepository;
import com.socceraround.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
public class UserService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

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
