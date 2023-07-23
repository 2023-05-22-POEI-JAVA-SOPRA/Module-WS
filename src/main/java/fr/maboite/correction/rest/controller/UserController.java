package fr.maboite.correction.rest.controller;

import fr.maboite.correction.jpa.entity.User;
import fr.maboite.correction.rest.pojo.UserPojo;
import fr.maboite.correction.service.UserService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
	
	private UserService userService = new UserService();
	
	@GET
	public String getUsers() {
		System.out.println("getUsers est appelée");
		return "Voici de beaux users";
	}
	
	@GET
	@Path("/{id}")
	public UserPojo getUsers(@PathParam("id") Integer id) {
		System.out.println("getUsers est appelée avec l'id : " + id);
		User user = this.userService.get(id);
		if (user == null) {
			return null;
		}
		return new UserPojo(user);
	}
	
	@POST
	public UserPojo save(UserPojo userPojo) {
		System.out.println("save est appelée");
		User savedUser = this.userService.save(userPojo.toUser());
		return new UserPojo(savedUser);
	}

	@DELETE
	@Path("/{id}")
	public void deleteUsers(@PathParam("id") Integer id) {
		System.out.println("deleteUsers est appelée avec l'id : " + id);
		this.userService.delete(id);
	}

}
