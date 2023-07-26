package fr.maboite.correction.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	
	@Email
	@NotNull
	@Size(max = 20)
	private String login;
	

	@NotNull
	@Size(max = 20)
	private String password;
	
	@NotNull
	private Integer connectionNumber;

	public User(User user) {
		// TODO Auto-generated constructor stub
	}

	public User() {
		// TODO Auto-generated constructor stub
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
}
