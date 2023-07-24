package entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name = "Article")
public class Article {

	//@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Positive
	private int idArticle;
	
	@NotNull
	@Size(min=1,max=255,
	message="Attention, "
			+ "la description doit contenir minimum 1"
			+ " caractère et maxixmum 255 caractères")
	private String description;
	
	
	private String brand;

	private Float price;


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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand + ", price="
				+ price + "]";
	}

	public Article() {
		super();
	}

	public Article(String description, String brand, Float price) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	

}
