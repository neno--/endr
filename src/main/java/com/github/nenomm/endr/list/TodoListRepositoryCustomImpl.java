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


        List<TodoListDTO> todoListDTOS = entityManager.createQuery(
            "select new " +
                "    com.github.nenomm.endr.list.TodoListDTO( " +
                "    tl.id, " +
                "    tl.name " +
                ") " +
                "from com.github.nenomm.endr.list.TodoList tl join tl.collaborations c " +
                "where c.user.id = :user_id", TodoListDTO.class)
            .setParameter("user_id", entityIdentifier)
            .getResultList();


        return todoListDTOS;
    }
}
