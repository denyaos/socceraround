package com.socceraround.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FriendshipPK implements Serializable {

    private long playerId;
    private long friendId;

    public FriendshipPK(long playerId, long friendId) {
        this.playerId = playerId;
        this.friendId = friendId;
    }

    @Override
    public int hashCode() {
        return (int) (playerId + friendId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FriendshipPK) {
            FriendshipPK other = (FriendshipPK) obj;
            return
                    playerId == other.playerId && friendId == other.friendId
                            ||
                    playerId == other.friendId && friendId == other.playerId;
        } else {
            return false;
        }
    }
}
