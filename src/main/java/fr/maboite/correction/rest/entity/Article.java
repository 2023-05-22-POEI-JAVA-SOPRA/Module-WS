package fr.maboite.correction.rest.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Article {
	
	private static int idCounter = 1;

	@NotNull @Positive @Min(value = 1)@Max(value = 99)
	private Integer idArticle;
	
	@Size(min=1,max=20)@NotEmpty
	private String description;
	private String brand;
	private float price;
	
	public Article() {
		super();
	}

	public Article(String description, String brand, float price) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
	}

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}
	
	public void setIdArticle() {
		this.idArticle = idCounter++;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Article [Description=" + description + ", Brand=" + brand + ", Price=" + price + "]";
	}
	
	
}
