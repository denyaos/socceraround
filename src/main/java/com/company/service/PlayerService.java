package com.company.service;

import com.company.domain.Player;
import com.company.domain.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player getPlayerById(long id) {
        return playerRepository.findOne(id);
    }

    public List<Player> getAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }
}
