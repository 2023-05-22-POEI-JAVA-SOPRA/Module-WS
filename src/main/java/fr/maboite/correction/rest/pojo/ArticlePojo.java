package fr.maboite.correction.rest.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ArticlePojo {
	
	private int idArticle;
	
	@NotNull
	@Size(max = 30, message="tu as fait une erreur")
	private String description;
	
	@NotNull
	@Size(max = 30, message="tu as fait une erreur")
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
	
	
	@Override
	public String toString() {
		return "ArticlePojo [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand
				+ ", unitaryPrice=" + unitaryPrice + "]";
	}
	public ArticlePojo() {
		super();
	}
	
	

}
