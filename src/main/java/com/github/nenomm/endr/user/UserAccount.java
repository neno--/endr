package com.github.nenomm.endr.user;

import com.github.nenomm.endr.core.EntityIdentifier;
import org.springframework.util.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserAccount {

    @EmbeddedId
    private EntityIdentifier id = new EntityIdentifier();

    @Column(nullable = false, unique = true)
    private String email;

    @Embedded
    private Password password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Column(nullable = false, unique = false)
    private OffsetDateTime registeredAt;

    public UserAccount(String email, Password password) {
        Assert.notNull(email, "email must not be null");
        Assert.notNull(password, "password must not be null");
    }

    public void setUser(User user) {
        Assert.notNull(user, "user must not be null");
        this.user = user;
    }

    public void addRole(Role role) {
        Assert.notNull(role, "role must not be null");
        roles.add(role);
    }

    public boolean hasRole(Role role) {
        Assert.notNull(role, "role must not be null");
        return roles.contains(role);
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        Assert.notNull(password, "password must not be null");
        this.password = password;
    }
}
