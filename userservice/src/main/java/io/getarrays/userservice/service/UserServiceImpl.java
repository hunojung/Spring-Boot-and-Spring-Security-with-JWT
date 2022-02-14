package io.getarrays.userservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.repo.RoleRepo;
import io.getarrays.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		log.info("Saving new user {} to the database",user.getName());
		return userRepo.save(user);
	}

	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		log.info("Saving new role {} to the database",role.getName());
		return roleRepo.save(role);
	}

	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		log.info("Adding role {} to user {}",roleName,username);
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		log.info("Fetching user {}",username);
		return userRepo.findByUsername(username);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		log.info("Fetching users");
		return userRepo.findAll();
	}
}