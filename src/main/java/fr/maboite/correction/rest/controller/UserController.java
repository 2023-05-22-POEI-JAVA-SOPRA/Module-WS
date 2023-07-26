package fr.maboite.correction.rest.controller;


import java.util.List;

import fr.maboite.correction.jpa.entity.User;
import fr.maboite.correction.rest.pojo.UserRestDto;
import fr.maboite.correction.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
	
	private UserService service = new UserService();
	
	@GET
	@Path("/id/{param}")
	public Response getById(@PathParam("param") Integer id) {
		User u = service.getById(id);
		if (u == null) {
			return Response.status(Status.NOT_FOUND).entity("User not found").type(MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok(new UserRestDto(u)).build();
		}
	}
	
	@GET
	public Response getAll() {
		List<User> users = service.getAll();
		if (users == null) {
			return Response.status(Status.NOT_FOUND).entity("Users not found").type(MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok(UserRestDto.usersToUsersRestDto(service.getAll())).build();
		}
	}
	
	@POST
	public Response create(@Valid UserRestDto urd) {
		User user = urd.convertToUser();
		if (service.create(user)) {
			return Response.ok("User created", MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok("User not created", MediaType.TEXT_PLAIN).build();
		}
	}
	
	@PUT @Path("id/{param}")
	public Response update(@Valid UserRestDto urd, @PathParam("param") Integer id) {
		User u = urd.convertToUser();
		if (service.update(u , id)) {
			return Response.ok("User updated").build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("User not updated").type(MediaType.TEXT_PLAIN).build();

		}
	}
	
	@DELETE @Path("id/{param}")
	public Response delete(@PathParam("param") Integer id) {
		if (service.delete(id)) {
			return Response.ok("User deleted").build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("User not deleted").type(MediaType.TEXT_PLAIN).build();

		}
	}
	
}
