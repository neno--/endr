package com.github.nenomm.endr.user;

import com.github.nenomm.endr.list.Collaboration;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIntegrationTest {

    @Autowired
    UserRepository repository;

    @Test
    @Transactional
    public void findUsers() {

        Iterable<User> result = repository.findAll();

        assertThat(result, is(Matchers.<User>iterableWithSize(1)));

        User user = result.iterator().next();

        assertThat(user.getCollaborations(), is(Matchers.<Collaboration>hasSize(1)));
    }

    @Test
    @Transactional
    public void findUser() {

        User user = repository.findByNick("testNick");

        assertThat(user, notNullValue());

        UserAccount userAccount = user.getUserAccount();

        assertThat(userAccount, notNullValue());
        assertThat(userAccount.getPrivileges(), is(not((empty()))));
    }
}
