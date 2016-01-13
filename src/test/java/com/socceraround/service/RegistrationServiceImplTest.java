package com.socceraround.service;

import com.socceraround.domain.User;
import com.socceraround.domain.dto.PlayerRegistrationModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;


public class RegistrationServiceImplTest extends BaseTest {

    @Mock
    private UserService userService;
    @Mock
    private PlayerService playerService;

    private RegistrationService registrationService;

    @Before
    public void setUp() throws Exception {
        registrationService = new RegistrationServiceImpl(userService, playerService);
    }

    @Test
    public void testRegisterPlayer_happyFlow() throws Exception {
        PlayerRegistrationModel model = makeRegistrationModel();
        registrationService.registerPlayer(model);
        verify(userService).registerUser(model);
        verify(playerService).register(any(User.class));

    }

    private PlayerRegistrationModel makeRegistrationModel() {
        PlayerRegistrationModel model = new PlayerRegistrationModel();
        model.setUsername("Alan");
        model.setPassword("pass");
        return model;
    }
}