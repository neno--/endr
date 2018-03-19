package com.github.nenomm.endr.list;

import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CollaborationId implements Serializable {

    @Column(name = "todoListId")
    private Long todoListId;

    @Column(name = "userId")
    private Long userId;

    public CollaborationId() {
    }

    public CollaborationId(Long todoListId, Long userId) {
        Assert.notNull(todoListId, "Todo list identifier must not be null");
        Assert.notNull(userId, "User identifier must not be null");

        this.todoListId = todoListId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollaborationId that = (CollaborationId) o;
        return Objects.equals(todoListId, that.todoListId) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoListId, userId);
    }
}
