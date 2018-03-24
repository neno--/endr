package com.github.nenomm.endr.user;


import com.github.nenomm.endr.core.EntityIdentifier;
import com.github.nenomm.endr.list.Collaboration;
import com.github.nenomm.endr.list.TodoList;
import org.springframework.util.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import java.time.OffsetDateTime;
import java.util.Collections;
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
    @OrderBy("created_at DESC")
    private Set<Collaboration> collaborations = new TreeSet<>();

    // for hibernate
    private User() {
    }

    public User(String nick, UserAccount userAccount) {
        Assert.hasText(nick, "nick must not be null or empty");
        Assert.notNull(userAccount, "user account must not be null");

        this.nick = nick;
        this.userAccount = userAccount;
    }

    public User(EntityIdentifier id, String nick, UserAccount userAccount, Set<Collaboration> collaborations) {
        this.id = id;
        this.nick = nick;
        this.userAccount = userAccount;
        this.collaborations = collaborations;
    }

    public String getNick() {
        return nick;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Set<Collaboration> getCollaborations() {
        return Collections.unmodifiableSet(collaborations);
    }

    public void addList(TodoList todoList) {
        Collaboration collaboration = new Collaboration(this, todoList, Collaboration.Privilege.CREATE, OffsetDateTime.now());
        collaborations.add(collaboration);
    }
}
