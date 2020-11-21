package com.company.service;

import com.company.dao.impl.UserRepositoryCustom;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private UserRepositoryCustom userRepo;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return null;
    }
}
