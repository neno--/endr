package com.github.nenomm.endr.user;


import com.github.nenomm.endr.list.Collaboration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String firstName;

    private String lastName;

    @OneToOne
    @JoinColumn(name = "ID")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "user")
    @OrderBy("todoList.name DESC")
    private Set<Collaboration> collaborations = new TreeSet<>();
}
