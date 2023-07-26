package fr.maboite.correction.rest.pojo;



import fr.maboite.correction.jpa.entity.Article;

public class ArticleRestDto {
	
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

	public ArticleRestDto(String description, String brand, float unitaryPrice) {
		super();
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}
	
	public ArticleRestDto(Article article) {
		idArticle = article.getIdArticle();
		description = article.getDescription();
		brand = article.getBrand();
		unitaryPrice = article.getUnitaryPrice();
	}

	public ArticleRestDto() {
		super();
	}

	@Override
	public String toString() {
		return "ArticleRestDto [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand
				+ ", unitaryPrice=" + unitaryPrice + "]";
	}
	
	
	/*
	 * public static List<ArticleRestDto> articlesToArticlesRestDto(List<Article>
	 * articles) { List<ArticleRestDto> list = new ArrayList<ArticleRestDto>(); for
	 * (Article article : articles) { list.add(new ArticleRestDto()); } return list;
	 * }
	 */
	

}
