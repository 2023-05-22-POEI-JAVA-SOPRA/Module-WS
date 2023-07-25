package fr.maboite.correction.rest.pojo;
import fr.maboite.correction.jpa.entity.Role;


public class RoleRestDto {
	
	private Integer idRole;
	private String name;
	
	public RoleRestDto() {
	}
	
	public RoleRestDto(Role role) {
		this.idRole = role.getIdRole();
		this.name = role.getName();
	}
	
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role toRole() {
		Role role = new Role();
		role.setIdRole(this.idRole);
		role.setName(this.name);
		return role;
	}
}
