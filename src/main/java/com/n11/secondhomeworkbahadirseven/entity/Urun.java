package com.n11.secondhomeworkbahadirseven.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
 * id adi fiyat kayitTarihi KategoriId
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "URUN")
public class Urun implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "generator", sequenceName = "URUN_ID_SEQ")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(length = 50, name = "ADI")
	private String adi;

	@Column(name = "FIYAT", precision = 19, scale = 2)
	private BigDecimal fiyat;

	@Column(name = "KAYIT_TARIHI")
	@Temporal(TemporalType.TIMESTAMP)
	private Date kayitTarihi;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kategori_id", foreignKey = @ForeignKey(name = "FK_URUN_KATEGORI_ID"))
	private Kategori kategori;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public BigDecimal getFiyat() {
		return fiyat;
	}

	public void setFiyat(BigDecimal fiyat) {
		this.fiyat = fiyat;
	}

	public Date getKayitTarihi() {
		return kayitTarihi;
	}

	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	@Override
	public String toString() {
		return "Urun{" +
				"id=" + id +
				", adi='" + adi + '\'' +
				", fiyat=" + fiyat +
				", kayitTarihi=" + kayitTarihi +
				", kategori=" + kategori +
				'}';
	}
}
