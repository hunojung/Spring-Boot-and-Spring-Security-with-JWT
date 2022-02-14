package io.getarrays.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
