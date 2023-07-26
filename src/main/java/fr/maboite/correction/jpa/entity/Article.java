package fr.maboite.correction.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int idArticle;

	private String description;

	private String brand;

	private float unitaryPrice;

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(float unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public Article() {
		super();
	}

	public Article(String description, String brand, float unitaryPrice) {
		super();
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}

}