package com.github.nenomm.endr.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Password {

    @Column(nullable = false, unique = false)
    String password;
}
