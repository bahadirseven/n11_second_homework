package com.n11.secondhomeworkbahadirseven.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n11.secondhomeworkbahadirseven.dto.UserDTO;
import com.n11.secondhomeworkbahadirseven.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<UserDTO> findAllUsers() {
		return userService.findAllUser();
	}

	@GetMapping("/username/{username}")
	public UserDTO findUserByUsername(@PathVariable("username") String username) {
		return userService.findUserByUsername(username);
	}

	@GetMapping("/phone/{phone}")
	public UserDTO findUserByPhone(@PathVariable("phone") String phone) {
		return userService.findUserByPhone(phone);
	}

	@PostMapping
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDTO));
	}

	@DeleteMapping
	public ResponseEntity<String> deleteUserByUsernameAndPhone(@RequestBody UserDTO userDTO) {
		userService.deleteUserByUsernameAndPhone(userDTO);
		return ResponseEntity.ok("User deleted");
	}

	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.updateUser(userDTO));
	}
}
