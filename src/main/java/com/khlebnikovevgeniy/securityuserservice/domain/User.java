package com.khlebnikovevgeniy.securityuserservice.domain;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.AUTO;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	private String name;
	private String username;
	private String password;
	@ManyToMany(fetch = EAGER)
	private Collection<Role> roles = new ArrayList<>();

}
