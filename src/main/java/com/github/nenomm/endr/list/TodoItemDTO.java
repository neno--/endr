package com.github.nenomm.endr.list;

import java.time.OffsetDateTime;

public class TodoItemDTO {

    private String name;

    private String description;

    boolean complete;

    private OffsetDateTime createdAt;

    private OffsetDateTime completedAt;

    // todo: do we need user here?
    //private User completedBy;

    public TodoItemDTO(TodoItem todoItem) {
        this.name = todoItem.getName();
        this.description = todoItem.getDescription();
        this.complete = todoItem.isComplete();
        this.createdAt = todoItem.getCreatedAt();
        this.completedAt = todoItem.getCompletedAt();
    }
}
