package com.github.nenomm.endr.user;

import com.github.nenomm.endr.core.EntityIdentifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, EntityIdentifier> {

    public UserAccount findByEmail(String email);
}
