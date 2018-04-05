package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import com.github.nenomm.endr.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/todo-lists")
public class TodoListResource {

    private TodoListService todoListService;

    @Autowired
    public TodoListResource(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoListDTO> getTodoListsNew(Authentication authentication) {
        // todo:  try to make this functional

        List<TodoListDTO> result = todoListService.findByUserId(getUserId(authentication));

        for (TodoListDTO element : result) {
            element.add(linkTo(methodOn(TodoListResource.class).getTodoListsNew(authentication)).withSelfRel());
        }

        return result;
    }

    private static EntityIdentifier getUserId(Authentication authentication) {
        return ((CustomUserDetails) authentication.getDetails()).getUserId();
    }
}
