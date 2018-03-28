package com.github.nenomm.endr.user;

import com.github.nenomm.endr.core.EntityIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

/*    public User getUser(EntityIdentifier userId) {
        userRepository.fin
    }*/
}
