package com.in28minutes.rest.webservices.restfulwebservices.security;

import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}