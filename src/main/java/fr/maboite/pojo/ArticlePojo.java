package fr.maboite.pojo;

public class ArticlePojo {
	
	private int id;
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
	
	@Override
	public String toString() {
		return "articlePojo [id=" + id + ", name=" + name + "]";
	}
	
	

}
