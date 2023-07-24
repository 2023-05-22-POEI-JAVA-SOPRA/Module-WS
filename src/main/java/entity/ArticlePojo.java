package entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ArticlePojo {
	
	@NotNull
	@Positive
	private int id;
	
	@NotNull
	@NotEmpty
	@Size(min=1,max=255,
			message="Attention, "
					+ "la description doit contenir minimum 1"
					+ " caractère et maxixmum 255 caractères")
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	public ArticlePojo() {
		// TODO Auto-generated constructor stub
	}

	public ArticlePojo(@NotNull @Positive int id,
			@NotNull @Size(min = 1, max = 255, message = "Attention, la description doit contenir minimum 1 caractère et maxixmum 255 caractères") String name,
			@NotNull @Email String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ArticlePojo [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
