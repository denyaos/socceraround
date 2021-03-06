package com.socceraround.web;

import com.socceraround.domain.Player;
import com.socceraround.domain.repository.UserRepository;
import com.socceraround.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/player")
public class PlayerResource {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Player getUserById(@PathVariable("id") long id) {
        return playerService.getPlayerById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Player> getAllUsers() {
        return playerService.getAllPlayers();
    }

}
