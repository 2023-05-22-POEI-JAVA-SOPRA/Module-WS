package fr.maboite.correction.rest.controller;



import fr.maboite.correction.jpa.entity.Role;
import fr.maboite.correction.rest.pojo.RolePojo;
import fr.maboite.correction.service.RoleService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
public class RoleController {

	private RoleService roleService = new RoleService();
	
	

	@GET
	@Path("/{id}")
	public RolePojo getRole(@PathParam("id") Integer id) {
		System.out.println("getRole est appelée avec l'id : " + id);
		Role role = this.roleService.get(id);
		if (role == null) {
			return null;
		}
		return new RolePojo(role);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public RolePojo saveRole(@Valid RolePojo rolePojo) {
		System.out.println("saveRole est appelée");
		Role role = this.roleService.save(rolePojo.toRole());
		return new RolePojo(role);
	}
	
	
}
