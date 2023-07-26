package fr.maboite.correction.rest.controller.TP;

import java.util.List;

import fr.maboite.correction.jpa.entity.User;
import fr.maboite.correction.service.UserService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Rest Controller des User
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
	
	private UserService userService = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		System.out.println("getUsers est appelée");
		List<User> users = this.userService.findAll();
		
		if(users == null || users.stream().count() <= 0)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(users).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@PathParam("id") Integer id) {
		System.out.println("getUsers est appelée avec l'id : " + id);
		User user = this.userService.get(id);
		if (user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(user).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(User user) {
		System.out.println("save est appelée");
		User savedUser = this.userService.save(user);
		
		if (savedUser == null || savedUser.getIdUser() <= 0) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(user).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteUsers(@PathParam("id") Integer id) {
		System.out.println("deleteUsers est appelée avec l'id : " + id);
		this.userService.delete(id);
		
		return Response.ok("Suppression réussi").build();
	}

}
