package fr.maboite.correction.jpa.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int idArticle;

	private String description;

	private String brand;

	private float unitaryPrice;
	
	@OneToMany (mappedBy = "article")
	private List<CommandLine> commandLine;
	

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

	public Article() {
		super();
	}

	public Article(String description, String brand, float unitaryPrice) {
		super();
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, description, unitaryPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(description, other.description)
				&& Float.floatToIntBits(unitaryPrice) == Float.floatToIntBits(other.unitaryPrice);
	}

	public List<CommandLine> getCommandLine() {
		return commandLine;
	}

	public void setCommandLine(List<CommandLine> commandLine) {
		this.commandLine = commandLine;
	}

	

	

}