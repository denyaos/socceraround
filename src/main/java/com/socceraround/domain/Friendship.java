package com.socceraround.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Friendship {

    @EmbeddedId
    private FriendshipPK id;

    @Column(nullable = false)
    @Enumerated
    private FriendshipStatus status;

    public FriendshipStatus getStatus() {
        return status;
    }

    public void setStatus(FriendshipStatus status) {
        this.status = status;
    }

    enum FriendshipStatus {
        PENDING, ACCEPTED, REJECTED, DELETED
    }
}
