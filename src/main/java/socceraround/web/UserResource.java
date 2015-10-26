package socceraround.web;

import socceraround.domain.User;
import socceraround.domain.dto.PlayerRegistrationModel;
import socceraround.domain.repository.UserRepository;
import socceraround.service.PlayerService;
import socceraround.service.UserService;
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

    @Autowired
    private PlayerService playerService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(PlayerRegistrationModel model) {
        User user = userService.registerUser(model);
        playerService.register(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public User getCurrentUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findOneByUsername(principal.getUsername());
    }
}
