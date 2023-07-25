package fr.maboite.correction.rest.pojo;

import fr.maboite.correction.jpa.entity.Article;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ArticleRestDto {
	
	
	private Integer idArticle;
	@NotEmpty(message = "description field is required") 
	@Size(min = 3,max = 30,message = "description field must contain at least 3 characters and 30 at must")
	private String description;
	

	@NotEmpty(message = "brand field is required") 
	@Size(min = 3,max = 30,message = "brand field must contain at least 3 characters and 30 at must")
	private String brand;
	private double unitaryPrice;

	public ArticleRestDto() {
		// TODO Auto-generated constructor stub
	}

	public ArticleRestDto(Article article) {
		this.idArticle = article.getIdArticle();
		this.description = article.getDescription();
		this.brand = article.getBrand();
		this.unitaryPrice = article.getUnitaryPrice();
	}
	
	public Article toArticle()
	{
		Article art = new Article();
		art.setDescription(this.description);
		art.setIdArticle(this.idArticle);
		art.setUnitaryPrice(this.unitaryPrice);
		art.setBrand(this.brand);
		return art;
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
}
