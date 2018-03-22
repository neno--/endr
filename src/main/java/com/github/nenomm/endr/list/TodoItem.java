package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import com.github.nenomm.endr.user.User;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.OffsetDateTime;

@Entity
public class TodoItem {

    @EmbeddedId
    private EntityIdentifier id = new EntityIdentifier();

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    boolean complete;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    // since java persistence 2.2
    @Column(nullable = false)
    private OffsetDateTime completedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private TodoList todoList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    private User completedBy;

    public TodoItem(String name, String description, OffsetDateTime createdAt, TodoList todoList) {
        Assert.notNull(name, "name must not be null");
        Assert.notNull(createdAt, "createdAt must not be null");
        Assert.notNull(todoList, "todoList must not be null");
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.todoList = todoList;
        this.complete = false;
    }
}
