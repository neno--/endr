package com.github.nenomm.endr.list;

import com.github.nenomm.endr.user.User;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Entity
public class Collaboration {

    @EmbeddedId
    CollaborationId collaborationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todoListId", insertable = false, updatable = false)
    private TodoList todoList;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Privilege privilege;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    public enum Privilege {
        CREATE,
        VIEW,
        COMPLETE
    }

    public Collaboration(User user, TodoList todoList, Privilege privilege, OffsetDateTime createdAt) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(todoList, "todoList must not be null");
        Assert.notNull(privilege, "privilege must not be null");
        Assert.notNull(createdAt, "createdAt must not be null");
        this.user = user;
        this.todoList = todoList;
        this.privilege = privilege;
        this.createdAt = createdAt;
    }

    // todo: should we implement equals and hashCode here?
    // or perhaps they are used form the key class?
    // this class is used in set
}
