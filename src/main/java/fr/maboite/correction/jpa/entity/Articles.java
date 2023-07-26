package fr.maboite.correction.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import fr.maboite.correction.validator.CheckBrandPrice;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_Articles")
@CheckBrandPrice(allowedBrands = {"Rolex", "Ferrari", "Marque repère"}, message = "Test message")
public class Articles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idarticle")
	private Integer id;
	
	@NotNull
	@Size(min = 0, max = 30)
	private String description;
	
	@NotNull
	@Size(min = 0, max = 30)
	private String brand;
	
	@NotNull
	@Column(name = "unitaryprice")
	private double unitaryPrice;
	
	public Articles() {}
	
	
	/**
	 * @param description
	 * @param brand
	 * @param unitaryPrice
	 */
	public Articles(@NotNull @Size(max = 30) String description, @NotNull @Size(max = 30) String brand,
			@NotNull double unitaryPrice) {
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
