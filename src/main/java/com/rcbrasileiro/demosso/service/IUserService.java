package com.rcbrasileiro.demosso.service;

import java.util.Optional;

import com.rcbrasileiro.demosso.domain.User;

public interface IUserService {

	public String signUp(User user);

	public Optional<User> findByEmail(String email);
	
	public User save(User user);
	
	public User getUser();

}
