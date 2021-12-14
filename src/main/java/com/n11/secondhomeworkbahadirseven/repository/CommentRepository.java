package com.n11.secondhomeworkbahadirseven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n11.secondhomeworkbahadirseven.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	void deleteByUserId(Long userId);

	List<Comment> findAllByUserId(Long id);

	List<Comment> findAllByProductId(Long id);

}
