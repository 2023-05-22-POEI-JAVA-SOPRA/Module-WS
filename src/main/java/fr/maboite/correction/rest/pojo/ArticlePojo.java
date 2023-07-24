package fr.maboite.correction.rest.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ArticlePojo {

	
	private Integer id;
	
	@NotNull
	//@Size(min = 3, message = "Le nom doit contenir au moins 3 lettres")
	private String name;
	
	@Email
	private String email;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
