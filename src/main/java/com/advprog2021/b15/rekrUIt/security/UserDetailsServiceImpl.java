package com.advprog2021.b15.rekrUIt.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.advprog2021.b15.rekrUIt.model.UserModel;
import com.advprog2021.b15.rekrUIt.repository.UserDb;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDb userDb;

    @Override 
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = userDb.findByEmail(email);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        return new User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }

}