package entity;

public class Article {

	private int idArticle;
	
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
