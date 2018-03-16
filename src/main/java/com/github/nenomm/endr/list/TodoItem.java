package com.github.nenomm.endr.list;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    String name;

    String description;

    boolean complete;

    // todo add temporal type here

}
