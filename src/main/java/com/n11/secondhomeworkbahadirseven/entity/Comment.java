package com.n11.secondhomeworkbahadirseven.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * id comment commentDate product user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "yorum")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "COMMENT_ID_SEQ")
	@GeneratedValue(generator = "generator")
	private Long id;

	@Column(name = "comment", nullable = false, length = 500)
	private String comment;

	@Column(name = "comment_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_comment_product_id"))
	private Urun product;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_comment_user_id"))
	private User user;
}
