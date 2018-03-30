package com.github.nenomm.endr.list;

public class TodoListDTO {

    private String name;

    public TodoListDTO(TodoList todoList) {
        this.name = todoList.getName();
    }

    public String getName() {
        return name;
    }
}
