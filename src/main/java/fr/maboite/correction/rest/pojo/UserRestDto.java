package fr.maboite.correction.rest.pojo;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.entity.User;

public class UserRestDto {
	private Integer idUser;
	private String login;
	private String password;
	private Integer connectionNumber;


	public UserRestDto() {
		super();
	}


	public UserRestDto(String login, String password, Integer connectionNumber) {
		super();
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}


	public UserRestDto(User user) {
		idUser = user.getIdUser();
		login = user.getLogin();
		password = user.getPassword();
		connectionNumber = user.getConnectionNumber();
	}


	public Integer getIdUser() {
		return idUser;
	}


	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}


	public Integer getConnectionNumber() {
		return connectionNumber;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setConnectionNumber(Integer connectionNumber) {
		this.connectionNumber = connectionNumber;
	}


	@Override
	public String toString() {
		return "UserRestDto [idUser=" + idUser + ", login=" + login + ", password=" + password + ", connectionNumber="
				+ connectionNumber + "]\n";
	}


	public static List<UserRestDto> usersToUsersRestDto(List<User> users) {
		List<UserRestDto> list = new ArrayList<UserRestDto>();
		for (User user : users) {
			list.add(new UserRestDto(user));
		}
		return list;
	}
}