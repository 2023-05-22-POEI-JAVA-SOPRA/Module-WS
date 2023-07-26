package fr.maboite.correction.rest.controller;

import fr.maboite.correction.service.RoleService;
import fr.maboite.correction.validator.RequestValidator;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.entity.Role;
import fr.maboite.correction.rest.pojo.RoleDto;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
public class RoleController {

	
	private RoleService roleService = new RoleService();
	private RequestValidator rq = new RequestValidator();
	
	@GET
	public Response getAllRoles()
	{
		
		System.out.println("getAllRoles est appelée");
		List<Role> roles = this.roleService.findAll();
		List<RoleDto> roleDtos = new ArrayList<>();
		for (Role role : roles) {
			RoleDto roleDto = new RoleDto(role);
			roleDtos.add(roleDto);
		}
		return Response.ok(roleDtos).build();
	}
	
	
	@GET
	@Path("/{id}")
	public Response getRole(@PathParam("id") Integer id) {
		System.out.println("getRole est appelée avec l'id : " + id);
		if (!rq.validateId(id)) {
			return rq.response404();
		}
		Role role = this.roleService.get(id);
		if (role == null) {
			return Response.status(Status.NOT_FOUND).entity("{'cause': 'not found'}").build();
		}
	
		return Response.ok(role,MediaType.APPLICATION_JSON).build();
	}
	
	
	@POST 
	public RoleDto saveRole(@Valid RoleDto rolePojo) {
		System.out.println("Save Role  est appelée");
		Role savedRole = this.roleService.save(rolePojo.toRole());
		return new RoleDto(savedRole);
	}
	
	
}
