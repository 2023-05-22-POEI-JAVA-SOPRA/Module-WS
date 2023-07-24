package fr.maboite.correction.rest.controller.rest.pojo;


// Pojo: Plain Old Java Object
//Non final et aucun de ses champs ne peut l'être

public class ArticlePojo  {
	
	
	private static int idCounter = 1;
	
	
	private Integer id;
	
	private String name;
	
	private String brand;
	
	private double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setId() {
		this.id = idCounter++ ;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public ArticlePojo(Integer id, String name, String brand, double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		idCounter++;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArticlePojo() {
		super();
	}

	@Override
	public String toString() {
		return "ArticlePojo [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	

}
