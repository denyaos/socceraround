package com.socceraround.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Friendship {

    @EmbeddedId
    private FriendshipPK id;

    @Column(nullable = false)
    private FriendshipStatus status;

    public FriendshipPK getId() {
        return id;
    }

    public void setId(FriendshipPK id) {
        this.id = id;
    }

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
