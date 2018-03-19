package com.github.nenomm.endr.list;

import com.github.nenomm.endr.user.User;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Entity
public class Collaboration {

    @EmbeddedId
    CollaborationId collaborationId;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "todoListId", insertable = false, updatable = false)
    private TodoList todoList;

    @Enumerated(EnumType.STRING)
    private Privilege privilege;

    private OffsetDateTime createdAt;

    public enum Privilege {
        CREATE,
        VIEW,
        COMPLETE
    }

}
