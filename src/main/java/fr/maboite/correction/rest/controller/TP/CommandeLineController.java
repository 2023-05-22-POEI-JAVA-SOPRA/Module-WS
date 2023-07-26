package fr.maboite.correction.rest.controller.TP;

import java.util.List;

import fr.maboite.correction.jpa.dao.CommandeDAO;
import fr.maboite.correction.jpa.dao.CommandeLineDAO;
import fr.maboite.correction.jpa.entity.Commande;
import fr.maboite.correction.jpa.entity.CommandeLine;
import fr.maboite.correction.service.CommandeLineService;
import fr.maboite.correction.service.CommandeService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/commandelines")
@Produces(MediaType.APPLICATION_JSON)
public class CommandeLineController {
	
	private CommandeLineService commandeLineService = new CommandeLineService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandes() {
		
		System.out.println("getRoles est appelée");
		
		List<CommandeLine> commandeLines = this.commandeLineService.get();
		
		if(commandeLines == null || commandeLines.stream().count() <= 0)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(commandeLines).build();	
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandeLine(@PathParam("id") Integer id) {
		
		System.out.println("getCommandeLine est appelée avec l'id : " + id);
		CommandeLine commandeLine = this.commandeLineService.get(id);
		
		if (commandeLine == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(commandeLine).build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(CommandeLine commandeLine) {
		
		System.out.println("save est appelée");
		
		CommandeLine commandeStored = this.commandeLineService.save(commandeLine);
		
		if(commandeStored == null || commandeStored.getIdCommand() <= 0)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(commandeStored).build();
	}
	
	
}
