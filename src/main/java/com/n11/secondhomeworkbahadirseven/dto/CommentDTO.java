package com.n11.secondhomeworkbahadirseven.dto;

import java.util.Date;

import com.n11.secondhomeworkbahadirseven.entity.Comment;
import com.n11.secondhomeworkbahadirseven.entity.Urun;
import com.n11.secondhomeworkbahadirseven.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
	private Long id;
	private String comment;
	private Date commentDate;
	private Long productId;
	private Long userId;

	public static CommentDTO fromComment(Comment comment) {
		return CommentDTO.builder()
				.id(comment.getId())
				.comment(comment.getComment())
				.commentDate(comment.getCommentDate())
				.productId(comment.getProduct().getId())
				.userId(comment.getUser().getId())
				.build();
	}

	public static Comment fromCommentDTO(CommentDTO commentDTO) {
		return Comment.builder()
				.comment(commentDTO.getComment())
				.commentDate(commentDTO.getCommentDate())
				.product(Urun.builder().id(commentDTO.getProductId()).build())
				.user(User.builder().id(commentDTO.getUserId()).build())
				.build();
	}
}
