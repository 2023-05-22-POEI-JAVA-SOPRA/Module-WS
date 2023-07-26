package fr.maboite.correction.rest.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ArticlePojo {
	
	@Positive
	private Integer idArticle;
	
	@NotEmpty @Size(max=30)
	String description;
	
	@NotEmpty @Size(max=30)
	String brand;
	
	@NotEmpty
	double unitaryPrice;


	public ArticlePojo() {
		super();
	}

	public ArticlePojo(Integer idArticle, String description, String brand, double unitaryPrice) {
		super();
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
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

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	@Override
	public String toString() {
		return "Article [description=" + description + ", brand=" + brand + ", unitaryPrice=" + unitaryPrice + "]";
	}
}
