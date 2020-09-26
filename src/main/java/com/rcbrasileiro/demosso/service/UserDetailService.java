package com.rcbrasileiro.demosso.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rcbrasileiro.demosso.dao.IUserCrudDao;
import com.rcbrasileiro.demosso.domain.User;

@Service(value = "userDetailsService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    private IUserCrudDao userCrudDao;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOpt = userCrudDao.findByEmail(email);
        if(!userOpt.isPresent()){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(userOpt.get().getEmail(), userOpt.get().getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
