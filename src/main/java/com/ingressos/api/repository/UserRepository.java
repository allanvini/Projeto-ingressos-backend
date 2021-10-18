package com.ingressos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingressos.api.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsernameAndPassword(String username, String password);
}
