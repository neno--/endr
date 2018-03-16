package com.github.nenomm.endr.list;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;

@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    String name;

    @OneToMany(mappedBy = "todoList")
    @OrderBy("createdAt DESC")
    private List<Collaboration> collaborations;

    @OneToMany(mappedBy = "todoList")
    @OrderBy("createdAt DESC")
    private List<TodoItem> todoItems;


}
