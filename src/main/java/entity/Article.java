package entity;

public class Article {
	
	private static int idCounter = 1;

	private Integer idArticle;
	
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
