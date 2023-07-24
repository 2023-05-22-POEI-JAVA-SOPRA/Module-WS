package fr.maboite.correction.rest.controller.rest.pojo;

public class VoiturePojo {
	
	
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
