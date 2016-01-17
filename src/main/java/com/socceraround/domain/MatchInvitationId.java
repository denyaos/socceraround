package com.socceraround.domain;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MatchInvitationId implements Serializable {

    private long matchId;
    private long playerId;

    public MatchInvitationId(long matchId, long playerId) {
        this.matchId = matchId;
        this.playerId = playerId;
    }

    @Override
    public int hashCode() {
        return (int) (matchId + playerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MatchInvitationId) {
            MatchInvitationId other = (MatchInvitationId) obj;
            return matchId == other.matchId && playerId == other.playerId;
        } else
            return false;
    }
}
