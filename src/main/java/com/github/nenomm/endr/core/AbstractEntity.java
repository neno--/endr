package com.github.nenomm.endr.core;

import org.springframework.data.domain.Persistable;
import org.springframework.util.ObjectUtils;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.Transient;

@MappedSuperclass
public class AbstractEntity<T extends EntityIdentifier> implements Persistable<T> {

    T id;

    @Transient
    private boolean isNew = true;

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }

        AbstractEntity<?> that = (AbstractEntity<?>) obj;

        return ObjectUtils.nullSafeEquals(this.getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @PostPersist
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }
}
