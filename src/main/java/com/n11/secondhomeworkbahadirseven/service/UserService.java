package com.n11.secondhomeworkbahadirseven.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.n11.secondhomeworkbahadirseven.dto.UserDTO;
import com.n11.secondhomeworkbahadirseven.entity.User;
import com.n11.secondhomeworkbahadirseven.exception.UserNotFoundException;
import com.n11.secondhomeworkbahadirseven.repository.CommentRepository;
import com.n11.secondhomeworkbahadirseven.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final CommentRepository commentRepository;

	public List<UserDTO> findAllUser() {
		return userRepository.findAll().stream().map(UserDTO::fromUser).collect(Collectors.toList());
	}

	public UserDTO findUserByUsername(String username) {
		Optional<User> userOp = userRepository.findByUsername(username);

		if (userOp.isPresent()) {
			return UserDTO.fromUser(userOp.get());
		}

		return null;
	}

	public UserDTO findUserByPhone(String phone) {
		Optional<User> userOp = userRepository.findUserByPhone(phone);

		if (userOp.isPresent()) {
			return UserDTO.fromUser(userOp.get());
		}

		return null;
	}

	public UserDTO saveUser(UserDTO userDTO) {
		User user = UserDTO.fromUserDTO(userDTO);

		User savedUser = userRepository.save(user);

		return UserDTO.fromUser(savedUser);
	}

	@Transactional
	public void deleteUserByUsernameAndPhone(UserDTO userDTO) {
		User user = userRepository.findByUsernameAndPhone(userDTO.getUsername(), userDTO.getPhone())
				.orElseThrow(() -> new UserNotFoundException("Username or phone not found."));

		Long userId = user.getId();

		if (userId != null) {
			commentRepository.deleteByUserId(userId);
			userRepository.deleteByUsernameAndPhone(userDTO.getUsername(), userDTO.getPhone());
		}
	}

	public UserDTO updateUser(UserDTO userDTO) {
		User savedUser = null;
		User user = userRepository.findById(userDTO.getId()).orElseThrow(() -> new UserNotFoundException("User not found"));

		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		user.setSurname(userDTO.getSurname());
		user.setUsername(userDTO.getUsername());
		savedUser = userRepository.save(user);

		return UserDTO.fromUser(savedUser);
	}
}
