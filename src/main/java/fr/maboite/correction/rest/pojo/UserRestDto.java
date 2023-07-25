package fr.maboite.correction.rest.pojo;

import fr.maboite.correction.jpa.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class UserRestDto {

	
	private Integer idUser;
	@NotEmpty(message = "login field is required") 
	@Size(min = 3,max = 20,message = "login field must contain at least 3 characters and 20 at must")
	private String login;
	@NotEmpty(message = "password field is required") 
	@Size(min = 3,max = 20,message = "password field must contain at least 3 characters and 20 at must")
	private String password;
	@NotNull
	@PositiveOrZero(message = "connectionNumber field must be postive or equal to 0")
	private Integer connectionNumber;

	public UserRestDto() {

	}

	public UserRestDto(User user) {
		this.idUser = user.getIdUser();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.connectionNumber = user.getConnectionNumber();
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getConnectionNumber() {
		return connectionNumber;
	}

	public void setConnectionNumber(Integer connectionNumber) {
		this.connectionNumber = connectionNumber;
	}

	public User toUser() {
		User user = new User();
		user.setConnectionNumber(this.connectionNumber);
		user.setIdUser(this.idUser);
		user.setLogin(this.login);
		user.setPassword(this.password);
		return user;
	}

}
