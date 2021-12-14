package com.n11.secondhomeworkbahadirseven.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n11.secondhomeworkbahadirseven.dto.CommentDTO;
import com.n11.secondhomeworkbahadirseven.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;

	@GetMapping("/user/{id}")
	public List<CommentDTO> findAllCommentsByUserId(@PathVariable("id") Long id) {
		return commentService.findAllCommentsByUserId(id);
	}

	@GetMapping("/product/{id}")
	public List<CommentDTO> findAllCommentsByProductId(@PathVariable("id") Long id) {
		return commentService.findAllCommentsByProductId(id);
	}

	@PostMapping
	public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentDTO commentDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(commentService.saveComment(commentDTO));
	}

	@DeleteMapping
	public ResponseEntity<String> deleteCommentById(@RequestBody CommentDTO commentDTO) {
		commentService.deleteCommentById(commentDTO.getId());
		return ResponseEntity.ok("Comment deleted");
	}
}
