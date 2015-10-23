package com.company.web;

import com.company.domain.Player;
import com.company.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerResource {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
    public Player getUserById(@PathVariable("id") long id) {
        return playerService.getPlayerById(id);
    }

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public List<Player> getAllUsers() {
        return playerService.getAllPlayers();
    }
}
