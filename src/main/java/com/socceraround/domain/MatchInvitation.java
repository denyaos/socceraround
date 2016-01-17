package com.socceraround.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MatchInvitation {

    @EmbeddedId
    private MatchInvitationId id;

    @Column(nullable = false)
    private MatchInvitationStatus status;

    public MatchInvitationId getId() {
        return id;
    }

    public void setId(MatchInvitationId id) {
        this.id = id;
    }

    public MatchInvitationStatus getStatus() {
        return status;
    }

    public void setStatus(MatchInvitationStatus status) {
        this.status = status;
    }

    enum MatchInvitationStatus {
        PENDING, ACCEPTED, REJECTED
    }
}
