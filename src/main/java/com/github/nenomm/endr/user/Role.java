package com.github.nenomm.endr.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Role {

    @Column(nullable = false, unique = true)
    private String name;
}
