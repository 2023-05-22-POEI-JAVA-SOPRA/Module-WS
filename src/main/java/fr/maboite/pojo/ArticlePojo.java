package fr.maboite.pojo;

public class ArticlePojo {
	
	static private Integer counterId = 0;
	
	private Integer id;
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
