package com.github.nenomm.endr.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

}
