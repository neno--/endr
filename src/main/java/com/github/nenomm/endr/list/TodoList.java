package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.AbstractEntity;
import org.springframework.util.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class TodoList extends AbstractEntity {

    @Column(nullable = false)
    String name;

    @OneToMany(mappedBy = "todoList", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("createdAt DESC")
    private Set<Collaboration> collaborations = new HashSet<>();

    @OneToMany(mappedBy = "todoList", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("createdAt DESC")
    private List<TodoItem> todoItems = new ArrayList<>();

    // https://stackoverflow.com/questions/7273125/hibernate-envers-and-javassist-enhancement-failed-exception/7373445#7373445
    public TodoList() {
    }

    public TodoList(String name) {
        Assert.notNull(name, "name must not be null");
        this.name = name;
    }

    public void addItem(TodoItem todoItem) {
        todoItems.add(todoItem);
    }
}
