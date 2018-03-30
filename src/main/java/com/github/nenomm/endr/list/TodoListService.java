package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import com.github.nenomm.endr.user.User;

import java.util.List;
import java.util.Set;

public interface TodoListService {

    public Iterable<TodoList> findAll();

    public List<TodoListDTO> findByUser(EntityIdentifier entityIdentifier);
}
