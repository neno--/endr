package com.github.nenomm.endr.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAccountRepositoryIntegrationTest {

    @Autowired
    UserAccountRepository repository;

    @Test
    @Transactional
    public void findUserAccount() {

        UserAccount userAccount = repository.findByEmail("test@test.com");

        assertThat(userAccount, notNullValue());

        Password password = userAccount.getPassword();

        assertThat(password, notNullValue());
        assertThat(password, equalTo(Password.getNew("test123")));

        User user = userAccount.getUser();

        assertThat(user, notNullValue());
    }
}
