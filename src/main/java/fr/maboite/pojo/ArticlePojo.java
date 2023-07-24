package fr.maboite.pojo;

public class ArticlePojo {

	public int id;
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ArticlePojo [id=" + id + ", nom=" + nom + "]";
	}

}
