package entity;

public class ArticlePojo {				
	private int id;
	private String name;
	
	public ArticlePojo() {
		// TODO Auto-generated constructor stub
	}

	public ArticlePojo(int id, String name) {
		this.id = id;
		this.name = name;
	}

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
		return "ArticlePojo [id=" + id + ", name=" + name + "]";
	}
	
	
}
