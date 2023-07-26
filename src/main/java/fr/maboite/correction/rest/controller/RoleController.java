package fr.maboite.correction.rest.controller;

import fr.maboite.correction.service.RoleService;



import fr.maboite.correction.jpa.entity.Role;
import fr.maboite.correction.rest.pojo.RoleRestDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Rest Controller des Role
 */
@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
public class RoleController {
	
	private RoleService roleService = new RoleService();
	

	
	@GET
	@Path("/{id}")
	public RoleRestDto getRoles(@PathParam("id") Integer id) {
		System.out.println("getRoles est appelée avec l'id : " + id);
		Role role = this.roleService.get(id);
		if (role == null) {
			return null;
		}
		return new RoleRestDto(role);
	}
	
	@POST
	public RoleRestDto save(RoleRestDto rolePojo) {
		System.out.println("save est appelée");
		Role savedRole = this.roleService.save(rolePojo.toRole());
		return new RoleRestDto(savedRole);
	}

	
}