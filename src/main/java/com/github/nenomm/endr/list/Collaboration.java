package com.github.nenomm.endr.list;

import com.github.nenomm.endr.user.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Collaboration {

    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "TODOLIST_ID")
    private TodoList todoList;

    @Enumerated(EnumType.STRING)
    private Privilege privilege;

    public enum Privilege {
        OWN,
        VIEW,
        COMPLETE
    }

}
