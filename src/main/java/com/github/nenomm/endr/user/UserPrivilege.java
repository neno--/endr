package com.github.nenomm.endr.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public enum UserPrivilege implements GrantedAuthority {
    ADMIN,
    USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
