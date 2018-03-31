package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTodoListService implements TodoListService {

    private TodoListRepository todoListRepository;

    @Autowired
    public DefaultTodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public List<TodoListDTO> findByUserId(EntityIdentifier entityIdentifier) {
        return todoListRepository.findByUserId(entityIdentifier);
    }
}
