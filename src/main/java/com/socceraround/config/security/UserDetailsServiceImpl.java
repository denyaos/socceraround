package com.socceraround.config.security;

import com.socceraround.domain.User;
import com.socceraround.service.UserService;
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

        //todo: use spring's user to get rid of UserDetailsImpl
        return new UserDetailsImpl(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
