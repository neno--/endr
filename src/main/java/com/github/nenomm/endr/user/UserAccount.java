package com.github.nenomm.endr.user;

import org.springframework.util.Assert;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String email;

    @Embedded
    private Password password;

    // user is optional
    @OneToOne(mappedBy = "userAccount")
    private User user;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

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
