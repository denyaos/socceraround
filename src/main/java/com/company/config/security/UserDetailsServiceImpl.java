package com.company.config.security;

import com.company.domain.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserWithAuthorities(username);

        if (user == null)
            throw new UsernameNotFoundException("No user found with username " + username);

        return new UserDetailsImpl(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
