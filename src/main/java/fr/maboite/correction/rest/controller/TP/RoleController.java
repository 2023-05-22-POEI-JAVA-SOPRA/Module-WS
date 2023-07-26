package fr.maboite.correction.rest.controller.TP;

import java.util.List;

import fr.maboite.correction.jpa.entity.Roles;
import fr.maboite.correction.service.RoleService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
public class RoleController {
	
	private RoleService roleService = new RoleService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoles() {
		System.out.println("getRoles est appelée");
		List<Roles> roles = this.roleService.findAll();
		
		if(roles == null || roles.stream().count() <= 0)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(roles).build();	
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRole(@PathParam("id") Integer id) {
		System.out.println("getRole est appelée avec l'id : " + id);
		Roles role = this.roleService.get(id);
		if (role == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(role).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Roles role) {
		System.out.println("save est appelée");
		Roles savedRole = this.roleService.save(role);
		
		if(savedRole == null || savedRole.getId() <= 0)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(savedRole).build();
	}
}
