package fr.maboite.correction.rest.controller.rest.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VoiturePojo {
	
	
	private int id;
	
	@NotNull
	@Size(min = 3, max = 10 ,message = "Attention la taille de ce champ doit suivre la norme X")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VoiturePojo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public VoiturePojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
