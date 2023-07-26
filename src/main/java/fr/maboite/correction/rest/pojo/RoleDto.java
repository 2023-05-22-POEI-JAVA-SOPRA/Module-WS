package fr.maboite.correction.rest.pojo;

import fr.maboite.correction.jpa.entity.Role;
import fr.maboite.correction.jpa.entity.Roles;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RoleDto {
	
	
	private Integer id;
	@NotEmpty(message = "roleName field is required") 
	@Size(min = 3,max = 20,message = "roleName field must contain at least 3 characters and 20 at must")
	private String roleName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public RoleDto(Role role)
	{
		this.id= role.getId();
		this.roleName=role.getRoleName();
	}
	
	public Role toRole() 
	{
		Role role = new Role();
		role.setId(this.id);
		role.setRoleName(this.roleName);
		return role;
	
		
	}
	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleDto(Roles role) {
		// TODO Auto-generated constructor stub
	}
	
	
}
