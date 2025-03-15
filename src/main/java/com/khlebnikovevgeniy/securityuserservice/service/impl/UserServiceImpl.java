package com.khlebnikovevgeniy.securityuserservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khlebnikovevgeniy.securityuserservice.domain.Role;
import com.khlebnikovevgeniy.securityuserservice.domain.User;
import com.khlebnikovevgeniy.securityuserservice.repo.RoleRepo;
import com.khlebnikovevgeniy.securityuserservice.repo.UserRepo;
import com.khlebnikovevgeniy.securityuserservice.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
	
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;

	@Override
	public User saveUser(User user) {
		log.info("Saving a new user {} to the database", user.getName());
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving a new role {} to the database", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Addaing a role {} to the user {}", roleName, username);
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role); //transactional execution
	}

	@Override
	public User getUser(String username) {
		log.info("Fetching a user {}", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		log.info("Getting all the users from the database");
		return userRepo.findAll();
	}

}
