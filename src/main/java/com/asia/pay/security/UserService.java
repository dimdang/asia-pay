package com.asia.pay.security;

import com.asia.pay.model.Role;
import com.asia.pay.model.User;
import com.asia.pay.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dang Dim
 * Date     : 3/25/19, 1:38 PM
 * Email    : dangdim02@gmail.com
 */

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        log.debug("Authenticating {}", username);

        User user = null;

        if (username != null)
            user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        } else if (!user.isActivated()) {
            throw new UserNotActivatedException("User " + username + " is not activated");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role authority : user.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

    }
}