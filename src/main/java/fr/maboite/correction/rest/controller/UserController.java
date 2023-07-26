package fr.maboite.correction.rest.controller;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.entity.User;
import fr.maboite.correction.rest.pojo.UserRestDto;
import fr.maboite.correction.service.UserService;
import fr.maboite.correction.validator.RequestValidator;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * Rest Controller des Users
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
	
	private UserService userService = new UserService();
	private RequestValidator rq = new RequestValidator();
	
	@GET
	public Response getUsers() {
		System.out.println("getUsers est appelée");
		List<User> users = this.userService.findAll();
		if(users.size() ==0)
		{
			return  Response.status(Status.NOT_FOUND).entity("{'cause': 'users list is empty'}").build();
		}
		
		List<UserRestDto> userDtos = new ArrayList<>();
		for (User user : users) {
			UserRestDto userDto = new UserRestDto(user);
			userDtos.add(userDto);
		}
		return Response.ok(userDtos,MediaType.APPLICATION_JSON).build();
//		return userDtos;
		// Les 6 lignes ci-dessus peuvent être remplacées par :
		// return users.stream().map(UserRestDto::new).toList();

	}
	
	@GET
	@Path("/{id}")
	public Response getUsers(@PathParam("id") Integer id) {
		System.out.println("getUsers est appelée avec l'id : " + id);
		if (!rq.validateId(id)) {
			rq.response404();
		}
		User user = this.userService.get(id);
	
		if (user == null) {
			return Response.status(Status.NOT_FOUND).entity("{'cause': 'not found'}").build();
		}
		return Response.ok(user,MediaType.APPLICATION_JSON).build();
	}
//	@GET
//	@Path("roles/{id}")
//	public Response getUserRoles(@PathParam("id") Integer id)
//	{
//		System.out.println("getUsers est appelée avec l'id : " + id);
//		if (id <= 0) {
//			System.out.println("id must be non negative or equal to 0");
//			return Response.status(Response.Status.NOT_FOUND).entity("{'cause': 'not found id must be non negative or equal to 0'}").type(MediaType.APPLICATION_JSON)/*header("typeOfInputMIME","json").header("typeOfOutputMIME", "json")*/.build();
//		}
//		//userRoleService
//		return Response.ok("",MediaType.APPLICATION_JSON).build();
//	}
	
	@POST
	public UserRestDto save(@Valid UserRestDto userPojo) {
		System.out.println("save est appelée");
		User savedUser = this.userService.save(userPojo.toUser());
		
		return new UserRestDto(savedUser);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsers(@PathParam("id") Integer id) {
		System.out.println("deleteUsers est appelée avec l'id : " + id);
		if (!rq.validateId(id)) {
			rq.response404();
		}
		if(userService.delete(id))
		{
			return Response.ok("User with userId: " + id +  " was deleted with success",MediaType.APPLICATION_JSON).build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).entity("{'cause': 'not found'}").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@DELETE
	@Path("/delete/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsers() {
		System.out.println("deleteUsers est appelée ");
		if(userService.deleteAll())
		{
			return Response.ok("All Users have benn deleted with success",MediaType.APPLICATION_JSON).build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).entity("{'cause': 'not found'}").type(MediaType.APPLICATION_JSON).build();
		}
	}

}
