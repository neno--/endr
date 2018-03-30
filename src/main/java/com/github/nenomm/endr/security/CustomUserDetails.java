package com.github.nenomm.endr.security;

import com.github.nenomm.endr.core.EntityIdentifier;

public class CustomUserDetails {
    EntityIdentifier userId;

    public CustomUserDetails(EntityIdentifier userId) {
        this.userId = userId;
    }

    public EntityIdentifier getUserId() {
        return userId;
    }
}
