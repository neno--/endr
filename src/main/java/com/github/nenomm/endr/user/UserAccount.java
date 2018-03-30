package com.github.nenomm.endr.user;

import com.github.nenomm.endr.core.AbstractEntity;
import org.springframework.util.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = UserPrivilege.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private Set<UserPrivilege> privileges = new HashSet<>();

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

    public void addPrivilege(UserPrivilege privilege) {
        Assert.notNull(privilege, "privilege must not be null");
        privileges.add(privilege);
    }

    public boolean hasRole(UserPrivilege role) {
        Assert.notNull(role, "role must not be null");
        return privileges.contains(role);
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        Assert.notNull(password, "password must not be null");
        this.password = password;
    }

    public Set<UserPrivilege> getPrivileges() {
        return Collections.unmodifiableSet(privileges);
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
            "email='" + email + '\'' +
            ", privileges=" + privileges +
            ", registeredAt=" + registeredAt +
            '}';
    }
}
