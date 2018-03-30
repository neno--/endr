package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepositoryCustom {

    public List<TodoListDTO> findByUser(EntityIdentifier entityIdentifier);
}
