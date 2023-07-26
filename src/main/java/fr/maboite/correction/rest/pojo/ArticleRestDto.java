package fr.maboite.correction.rest.pojo;

import fr.maboite.correction.jpa.entity.Article;

public class ArticleRestDto {

	private Integer idArticle;
	
	String description;
	
	String brand;
	
	double unitaryPrice;

	public ArticleRestDto() {
		super();
	}

	public ArticleRestDto(Article article) {
		super();
		this.idArticle = article.getIdArticle();
		this.description = article.getDescription();
		this.brand = article.getBrand();
		this.unitaryPrice = article.getUnitaryPrice();
	}
	
	public Article toArticle() {
		Article article = new Article();
		article.setIdArticle(this.idArticle);
		article.setDescription(this.description);
		article.setBrand(this.brand);
		article.setUnitaryPrice(this.unitaryPrice);
		return article;
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
