package com.github.nenomm.endr.user;

import com.github.nenomm.endr.core.AbstractEntity;
import org.springframework.util.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserAccount extends AbstractEntity {

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

    // for hibernate
    public UserAccount() {
    }

    public UserAccount(String email, Password password) {
        Assert.notNull(email, "email must not be null");
        Assert.notNull(password, "password must not be null");

        this.email = email;
        this.password = password;
        registeredAt = OffsetDateTime.now();
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

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
            "email='" + email + '\'' +
            ", roles=" + roles +
            ", registeredAt=" + registeredAt +
            '}';
    }
}
