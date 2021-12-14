package com.n11.secondhomeworkbahadirseven.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * id adi kirilim ustKategoriId
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "KATEGORI")
public class Kategori implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "generator", sequenceName = "KATEGORI_ID_SEQ")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "ADI", nullable = false, length = 50)
	private String adi;

	@Column(name = "KIRILIM")
	private Long kirilim;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UST_KATEGORI")
	private Kategori ustKategori;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Kategori getUstKategori() {
		return ustKategori;
	}

	public void setUstKategori(Kategori ustKategori) {
		this.ustKategori = ustKategori;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public Long getKirilim() {
		return kirilim;
	}

	public void setKirilim(Long kirilim) {
		this.kirilim = kirilim;
	}

	@Override
	public String toString() {
		return "Kategori{" +
				"id=" + id +
				", adi='" + adi + '\'' +
				", kirilim=" + kirilim +
				", ustKategori=" + ustKategori +
				'}';
	}
}
