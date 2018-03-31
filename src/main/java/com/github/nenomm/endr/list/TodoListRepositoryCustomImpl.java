package com.github.nenomm.endr.list;

import com.github.nenomm.endr.core.EntityIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

public class TodoListRepositoryCustomImpl implements TodoListRepositoryCustom {

    private Logger logger = LoggerFactory.getLogger(TodoListRepositoryCustomImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @PersistenceUnit
    EntityManagerFactory emf;

    private static String FIND_BY_USER_ID_JPQL =
        "select new " +
            "    com.github.nenomm.endr.list.TodoListDTO( " +
            "    tl.id, " +
            "    tl.name " +
            ") " +
            "from com.github.nenomm.endr.list.TodoList tl join tl.collaborations c " +
            "where c.user.id = :user_id";

    private static String FIND_BY_USER_ID = "findByUserId";

    @PostConstruct
    private void initializeStatements() {
        TypedQuery<TodoListDTO> findByUser = entityManager.createQuery(FIND_BY_USER_ID_JPQL, TodoListDTO.class);
        emf.addNamedQuery(FIND_BY_USER_ID, findByUser);
    }

    @Override
    public List<TodoListDTO> findByUserId(EntityIdentifier entityIdentifier) {

        logger.info("Fetch data for id: {}", entityIdentifier);


        List<TodoListDTO> todoListDTOS = entityManager.createNamedQuery(FIND_BY_USER_ID, TodoListDTO.class)
            .setParameter("user_id", entityIdentifier)
            .getResultList();


        return todoListDTOS;
    }
}
