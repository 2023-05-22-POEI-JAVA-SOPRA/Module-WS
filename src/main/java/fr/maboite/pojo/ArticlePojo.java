package fr.maboite.pojo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ArticlePojo {
	
	static private Integer counterId = 1;
	@PositiveOrZero
	@Min(value = 1)
	@Max(value = 100)
	private Integer id;
	@Size(min = 3)
	@NotNull
	private String name;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCounterId() {
		this.id = counterId++;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "articlePojo [id=" + id + ", name=" + name + "]";
	}
	
	

}
