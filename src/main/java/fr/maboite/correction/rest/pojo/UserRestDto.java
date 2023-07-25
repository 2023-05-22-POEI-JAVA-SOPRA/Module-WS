package fr.maboite.correction.rest.pojo;

import fr.maboite.correction.jpa.entity.User;

public class UserRestDto {

	private Integer idUser;

	private String login;

	private String password;

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
