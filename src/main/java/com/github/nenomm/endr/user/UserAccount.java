package com.github.nenomm.endr.user;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Set;
import java.util.TreeSet;

public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String email;

    private Password password;

    @OneToOne(mappedBy = "userAccount")
    private User user;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles = new TreeSet<Role>();
}
