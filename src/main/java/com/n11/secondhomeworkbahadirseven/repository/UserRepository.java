package com.n11.secondhomeworkbahadirseven.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n11.secondhomeworkbahadirseven.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findUserByPhone(String phone);

	void deleteByUsernameAndPhone(String username, String phone);

	Optional<User> findByUsernameAndPhone(String username, String phone);
}
