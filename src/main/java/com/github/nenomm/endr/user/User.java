package com.github.nenomm.endr.user;


import com.github.nenomm.endr.core.EntityIdentifier;
import com.github.nenomm.endr.list.Collaboration;
import org.springframework.util.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class User {

    @EmbeddedId
    private EntityIdentifier id = new EntityIdentifier();

    @Column(nullable = false, unique = false)
    private String nick;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private UserAccount userAccount;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("todoList.name DESC")
    private Set<Collaboration> collaborations = new TreeSet<>();

    public User(String nick, UserAccount userAccount) {
        Assert.hasText(nick, "nick must not be null or empty");
        Assert.notNull(userAccount, "user account must not be null");

        this.nick = nick;
        this.userAccount = userAccount;
    }
}
