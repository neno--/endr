package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;

public class TodoListDTO {

    private String id;

    private String name;

    public TodoListDTO(TodoList todoList) {
        this.id = todoList.getId().getIdentity();
        this.name = todoList.getName();
    }

    public TodoListDTO(EntityIdentifier entityIdentifier, String name) {
        this.id = entityIdentifier.getIdentity();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
