package com.github.nenomm.endr.security;

import com.github.nenomm.endr.user.Password;
import com.github.nenomm.endr.user.UserAccount;
import com.github.nenomm.endr.user.UserAccountRepository;
import com.github.nenomm.endr.user.UserPrivilege;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    private UserAccountRepository userAccountRepository;

    @Autowired
    public CustomAuthenticationProvider(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {

        String email = authentication.getName();
        Password password = Password.getNew(authentication.getCredentials().toString());

        logger.info("Trying to authenticate {}", email);

        UserAccount userAccount = userAccountRepository.findByEmail(email);

        if (userAccount == null) {
            throw new BadCredentialsException("email not found");
        } else if (!userAccount.getPassword().equals(password)) {
            throw new BadCredentialsException("invalid password");
        } else {
            logger.info("User login: {}", userAccount.toString());

            List<UserPrivilege> privileges = new ArrayList<>(userAccount.getPrivileges());
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password, privileges);

//            token.setDetails(new CustomUserDetails(userAccount.getUser().getId()));

            return token;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
            UsernamePasswordAuthenticationToken.class);
    }
}
