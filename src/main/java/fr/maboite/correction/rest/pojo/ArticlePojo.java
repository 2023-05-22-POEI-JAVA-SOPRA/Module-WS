package fr.maboite.correction.rest.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Un Plain Old Java Object
 * A chaque attribut correspond un getter et un setter (public)
 * Un constructeur public sans argument (le constructeur par defaut)
 * Il n'est pas final et aucun de ses champs ne l'est
 */

public class ArticlePojo {
	@NotNull
	private Integer id;
	@NotNull
 	private String name;
	@NotNull
	private String manufacturer;
	@NotNull
	@Min(20) @Max(30)
	private Float price;
	private static Integer counter = 0;
	
	
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public Float getPrice() {
		return price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setPrice(Float price) {
		this.price = price;
	}


	public void setId() {
		id = counter;
	}


	public ArticlePojo() {
		super();
		counter++;
	}
	public ArticlePojo(Integer id, String name, String manufacturer, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.price = price;
		counter++;
	}
	@Override
	public String toString() {
		return "ArticlePojo [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", price=" + price + "]";
	}
	
	
}
