package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, EntityIdentifier>, TodoListRepositoryCustom {
}
