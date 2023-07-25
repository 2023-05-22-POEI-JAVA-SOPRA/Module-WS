package fr.maboite.correction.rest.controller;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.entity.User;
import fr.maboite.correction.rest.pojo.UserRestDto;
import fr.maboite.correction.service.UserService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Rest Controller des User
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
	
	private UserService userService = new UserService();
	
	@GET
	public List<UserRestDto> getUsers() {
		System.out.println("getUsers est appelée");
		List<User> users = this.userService.findAll();
		List<UserRestDto> userDtos = new ArrayList<>();
		for (User user : users) {
			UserRestDto userDto = new UserRestDto(user);
			userDtos.add(userDto);
		}
		return userDtos;
		// Les 6 lignes ci-dessus peuvent être remplacées par :
		// return users.stream().map(UserRestDto::new).toList();

	}
	
	@GET
	@Path("/{id}")
	public UserRestDto getUsers(@PathParam("id") Integer id) {
		System.out.println("getUsers est appelée avec l'id : " + id);
		User user = this.userService.get(id);
		if (user == null) {
			return null;
		}
		return new UserRestDto(user);
	}
	
	@POST
	public UserRestDto save(UserRestDto userPojo) {
		System.out.println("save est appelée");
		User savedUser = this.userService.save(userPojo.toUser());
		return new UserRestDto(savedUser);
	}

	@DELETE
	@Path("/{id}")
	public void deleteUsers(@PathParam("id") Integer id) {
		System.out.println("deleteUsers est appelée avec l'id : " + id);
		this.userService.delete(id);
	}

}
