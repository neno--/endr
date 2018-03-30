package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import com.github.nenomm.endr.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/todo-lists")
public class TodoListResource {

    private TodoListService todoListService;

    @Autowired
    public TodoListResource(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<TodoListDTO> getTodoLists() {

        return StreamSupport.stream(todoListService.findAll().spliterator(), false).map(TodoListDTO::new).collect(Collectors.toSet());
    }

    @RequestMapping(value = "/v2", method = RequestMethod.GET)
    public List<TodoListDTO> getTodoListsNew(Authentication authentication) {
        return todoListService.findByUser(getUserId(authentication));
    }

    private static EntityIdentifier getUserId(Authentication authentication) {
        return ((CustomUserDetails) authentication.getDetails()).getUserId();
    }
}
