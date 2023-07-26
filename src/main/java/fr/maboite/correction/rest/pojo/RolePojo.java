package fr.maboite.correction.rest.pojo;

import fr.maboite.correction.jpa.entity.Role;
import jakarta.validation.constraints.NotNull;

public class RolePojo {

	
	private int idRole;
	
	@NotNull
	private String roleName;
	
	

	public RolePojo() {
		super();
	}
	public RolePojo(Role role) {
		this.idRole = role.getIdRole();
		this.roleName = role.getRoleName();
	}


	public Role toRole() {
		Role role = new Role();
		role.setIdRole(this.idRole);
		role.setRoleName(this.roleName);
		return role;
	}
	
	
	
	
	
	
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}	
}
