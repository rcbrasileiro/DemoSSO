package com.rcbrasileiro.demosso.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rcbrasileiro.demosso.dao.IUserCrudDao;
import com.rcbrasileiro.demosso.domain.User;
import com.rcbrasileiro.demosso.util.JwtTokenUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private IUserCrudDao userCrudDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public String signUp(User user) {

		Optional<User> userOpt = this.userCrudDao.findByEmail(user.getEmail());
		if (userOpt.isPresent()) {
			throw new RuntimeException("User already exist.");
		}
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		this.userCrudDao.save(user);
		return this.jwtTokenUtil.generateToken(user);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return this.userCrudDao.findByEmail(email);
	}

	@Override
	public User save(User user) {
		return this.userCrudDao.save(user);
	}

	@Override
	public User getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		Optional<User> userOpt = this.userCrudDao.findByEmail(username);
		if (userOpt.isPresent()) {
			return userOpt.get();
		}
		return null;
	}
}
