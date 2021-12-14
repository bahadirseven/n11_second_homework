package com.n11.secondhomeworkbahadirseven.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.n11.secondhomeworkbahadirseven.dto.CommentDTO;
import com.n11.secondhomeworkbahadirseven.entity.Comment;
import com.n11.secondhomeworkbahadirseven.exception.NoEntityFoundException;
import com.n11.secondhomeworkbahadirseven.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;

	public List<CommentDTO> findAllCommentsByUserId(Long id) {
		List<Comment> commentList = commentRepository.findAllByUserId(id);
		if (commentList.isEmpty()) {
			throw new NoEntityFoundException(String.format("User id: %s does not have any comments", id));
		}
		return commentList.stream().map(CommentDTO::fromComment).collect(Collectors.toList());
	}

	public List<CommentDTO> findAllCommentsByProductId(Long id) {
		List<Comment> commentList = commentRepository.findAllByProductId(id);
		if (commentList.isEmpty()) {
			throw new NoEntityFoundException(String.format("Product id: %s does not have any comments", id));
		}
		return commentList.stream().map(CommentDTO::fromComment).collect(Collectors.toList());
	}

	public CommentDTO saveComment(CommentDTO commentDTO) {
		Comment comment = CommentDTO.fromCommentDTO(commentDTO);

		Comment savedComment = commentRepository.save(comment);

		return CommentDTO.fromComment(savedComment);
	}

	@Transactional
	public void deleteCommentById(Long id) {
		commentRepository.deleteByUserId(id);
	}
}
