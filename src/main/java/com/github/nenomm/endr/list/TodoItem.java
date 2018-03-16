package com.github.nenomm.endr.list;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.Date;

public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String description;

    boolean complete;

    // this is hibernate specific - no need for converter.
    private ZonedDateTime completedAt;

}
