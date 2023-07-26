package fr.maboite.correction.jpa.entity;

import javax.persistence.Table;

@Table(name = "T_Users_Roles_Associations")
public class Users_Roles {
	
	
	private int idUser;
	
	private int idRole;

	
	/**
	 * @param idUser
	 * @param idRole
	 */
	public Users_Roles(int idUser, int idRole) {
		this.idUser = idUser;
		this.idRole = idRole;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	
	
}
