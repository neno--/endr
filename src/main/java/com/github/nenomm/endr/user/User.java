package com.github.nenomm.endr.user;


import com.github.nenomm.endr.list.Collaboration;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String nick;

    @OneToOne
    @JoinColumn(name = "USER_ACCOUNT_ID")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "user")
    @OrderBy("todoList.name DESC")
    private Set<Collaboration> collaborations = new TreeSet<>();

    public User(String nick, UserAccount userAccount) {
        Assert.notNull(nick, "nick must not be null");
        Assert.notNull(userAccount, "user account must not be null");

        this.nick = nick;
        this.userAccount = userAccount;
    }
}
