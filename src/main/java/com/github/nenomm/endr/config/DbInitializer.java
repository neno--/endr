package com.github.nenomm.endr.config;

import com.github.nenomm.endr.list.TodoList;
import com.github.nenomm.endr.user.Password;
import com.github.nenomm.endr.user.User;
import com.github.nenomm.endr.user.UserAccount;
import com.github.nenomm.endr.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
//@Profile("test")
public class DbInitializer {

    private Logger logger = LoggerFactory.getLogger(DbInitializer.class);

    private UserRepository userRepository;

    @Autowired
    public DbInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void initialize() {
        logger.info("Starting DB init...");

        UserAccount userAccount = new UserAccount("test@test.com", Password.getNew("test123"));
        User user = new User("testNick", userAccount);

        // add list to user
        TodoList list = new TodoList("testList");
        //TodoItem item = new TodoItem("testItem", "testDescription", OffsetDateTime.now(), list);

        //list.addItem(item);

        user.addList(list);

        userRepository.save(user);

        logger.info("DB init finished.");
    }
}
