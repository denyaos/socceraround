package socceraround.service;

import socceraround.domain.Player;
import socceraround.domain.User;
import socceraround.domain.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayerById(long id) {
        return playerRepository.findOne(id);
    }

    public List<Player> getAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    public void register(User user) {
        Player player = new Player();
        player.setUser(user);
        playerRepository.save(player);
    }


}
