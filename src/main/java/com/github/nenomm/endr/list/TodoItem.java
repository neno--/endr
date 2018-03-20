package com.github.nenomm.endr.list;

import com.github.nenomm.endr.user.User;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.OffsetDateTime;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String description;

    boolean complete;

    private OffsetDateTime createdAt;

    // since java persistence 2.2
    private OffsetDateTime completedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TODO_LIST_ID")
    private TodoList todoList;

    @OneToOne
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
