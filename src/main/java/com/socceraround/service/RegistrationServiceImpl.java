package com.socceraround.service;


import com.socceraround.domain.User;
import com.socceraround.domain.dto.PlayerRegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private UserService userService;
    private PlayerService playerService;

    @Autowired
    public RegistrationServiceImpl(UserService userService,
                                   PlayerService playerService) {
        this.userService = userService;
        this.playerService = playerService;
    }

    @Override
    public void registerPlayer(PlayerRegistrationModel model) {
        User user = userService.registerUser(model);
        playerService.register(user);
    }
}
