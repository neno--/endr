package com.github.nenomm.endr.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Password {

    @Column(nullable = false, unique = false)
    String password;

    private Password(String password) {
        this.password = password;
    }

    // enforcing immutability
    public static Password getNew(String password) {
        return new Password(password);
    }

    // for hibernate
    private Password() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Password that = (Password) o;

        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
