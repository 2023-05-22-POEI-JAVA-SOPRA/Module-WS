package fr.maboite.correction.rest.pojo;

public class VoiturePojo {
	private Integer id;
	private String name;
	
	
	public VoiturePojo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	public VoiturePojo() {
		super();
	}



	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
