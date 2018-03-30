package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TodoListRepositoryCustomImpl implements TodoListRepositoryCustom {

    private Logger logger = LoggerFactory.getLogger(TodoListRepositoryCustomImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<TodoListDTO> findByUser(EntityIdentifier entityIdentifier) {

        logger.info("Fetch data for id: {}", entityIdentifier);

        /*List<TodoListDTO> todoListDTOS = entityManager.createQuery(
            "select new " +
                "    com.github.nenomm.endr.list.TodoListDTO(" +
                "    tl.id, " +
                "    tl.name " +
                ") " +
                "from TodoList tl inner join Collaboration c on tl.id = c.todo_list_id " +
                "where c.user_id = :user_id", TodoListDTO.class)
            .setParameter("user_id", entityIdentifier.getIdentity())
            .getResultList();*/


        return null;
    }
}
