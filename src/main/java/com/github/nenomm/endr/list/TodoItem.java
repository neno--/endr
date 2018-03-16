package com.github.nenomm.endr.list;

import com.github.nenomm.endr.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String description;

    boolean complete;

    private ZonedDateTime createdAt;

    // this is hibernate specific - no need for converter.
    private ZonedDateTime completedAt;

    @ManyToOne
    @JoinColumn(name = "TODOLIST_ID")
    private TodoList todoList;

    @OneToOne
    @JoinColumn(name = "ID")
    private User completedBy;
}
