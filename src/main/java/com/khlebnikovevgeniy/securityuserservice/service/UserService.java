package com.khlebnikovevgeniy.securityuserservice.service;

import java.util.List;

import com.khlebnikovevgeniy.securityuserservice.domain.Role;
import com.khlebnikovevgeniy.securityuserservice.domain.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String userName);
	List<User>getUsers();
}
