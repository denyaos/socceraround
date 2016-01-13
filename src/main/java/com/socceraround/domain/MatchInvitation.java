package com.socceraround.domain;

import javax.persistence.Entity;

@Entity
public class MatchInvitation extends SAEntity {

    //todo: needs to create composite primary key here

    private Match match;
    private Player player;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
