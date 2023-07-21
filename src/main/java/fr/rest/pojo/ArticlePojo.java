package fr.rest.pojo;

public class ArticlePojo {
	
private Integer id;
private String nom;


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public ArticlePojo(Integer id, String nom) {
	super();
	this.id = id;
	this.nom = nom;
}


public ArticlePojo() {
	super();
}


@Override
public String toString() {
	return "ArticlePojo [id=" + id + ", nom=" + nom + "]";
}

}
