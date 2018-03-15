package com.github.nenomm.endr.user;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    private String firstName;

    private String lastName;

    @OneToOne
    @JoinColumn(name="ID")
    private UserAccount userAccount;
}
