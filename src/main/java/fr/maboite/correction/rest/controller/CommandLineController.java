package fr.maboite.correction.rest.controller;

import fr.maboite.correction.jpa.entity.CommandLine;
import fr.maboite.correction.rest.pojo.CommandLineRestDto;
import fr.maboite.correction.service.CommandLineService;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class CommandLineController {

	private CommandLineService service = new CommandLineService();

	@GET
	@Path("/{idCommandLine}")
	public Response getById(@PathParam("idCommandLine") Integer id) {
		CommandLine co = service.getById(id);
		if (co == null) {
			return Response.status(Status.NOT_FOUND).entity("CommandLine not found").type(MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok(new CommandLineRestDto(co)).build();
		}
	}

	@POST
	public Response create(@Valid CommandLineRestDto urc) {
		CommandLine commandLine = new CommandLine(urc.getIdCommand(), urc.getIdArticle(), urc.getQuantity());
		if (service.create(commandLine)) {
			return Response.ok("commandLine created", MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok("commandLine not created", MediaType.TEXT_PLAIN).build();
		}
	}

}
