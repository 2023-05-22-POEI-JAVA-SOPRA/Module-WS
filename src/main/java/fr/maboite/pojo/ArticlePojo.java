package fr.maboite.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ArticlePojo {
	@Positive(message = "L'id doit être positif")
	public Integer id;
	
	@NotNull
	@Size(min=3, max = 10, message ="La taille doit être comprise en 3 et 10 caractères.")
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ArticlePojo [id=" + id + ", nom=" + nom + "]";
	}

}
