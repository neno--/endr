package com.github.nenomm.endr.list;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    String name;

    @OneToMany(mappedBy = "todoList")
    @OrderBy("createdAt DESC")
    private Set<Collaboration> collaborations = new HashSet<>();

    @OneToMany(mappedBy = "todoList")
    @OrderBy("createdAt DESC")
    private List<TodoItem> todoItems = new ArrayList<>();
}
