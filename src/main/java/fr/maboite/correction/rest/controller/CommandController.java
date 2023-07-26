package fr.maboite.correction.rest.controller;

import java.util.List;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.User;
import fr.maboite.correction.rest.pojo.CommandRestDto;
import fr.maboite.correction.rest.pojo.UserRestDto;
import fr.maboite.correction.service.CommandService;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class CommandController {
	private CommandService service = new CommandService();
	
	@GET
	@Path("/id/{param}")
	public Response getById(@PathParam("param") Integer id) {
		Command c = service.getById(id);
		if (c == null) {
			return Response.status(Status.NOT_FOUND).entity("User not found").type(MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok(new CommandRestDto(c)).build();
		}
	}
	
	@GET
	public Response getAll() {
		List<Command> users = service.getAll();
		if (users == null) {
			return Response.status(Status.NOT_FOUND).entity("Users not found").type(MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok(CommandRestDto.commandsToCommandsRestDtos(service.getAll())).build();
		}
	}
	
	@POST
	public Response create(@Valid CommandRestDto crd) {
		Command command = crd.convertToCommand();
		if (service.create(command)) {
			return Response.ok("Command created", MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok("Command not created", MediaType.TEXT_PLAIN).build();
		}
	}
	
	@PUT @Path("id/{param}")
	public Response update(@Valid CommandRestDto crd, @PathParam("param") Integer id) {
		Command command = crd.convertToCommand();
		if (service.update(command , id)) {
			return Response.ok("Command updated").build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("Command not updated").type(MediaType.TEXT_PLAIN).build();
		}
	}
	
	@DELETE @Path("id/{param}")
	public Response delete(@PathParam("param") Integer id) {
		if (service.delete(id)) {
			return Response.ok("Command deleted").build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("Command not deleted").type(MediaType.TEXT_PLAIN).build();
		}
	}
}
