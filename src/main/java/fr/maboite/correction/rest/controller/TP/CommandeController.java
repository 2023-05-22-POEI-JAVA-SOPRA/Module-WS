package fr.maboite.correction.rest.controller.TP;

import java.util.List;

import fr.maboite.correction.jpa.entity.Commande;
import fr.maboite.correction.jpa.entity.Roles;
import fr.maboite.correction.service.CommandeService;
import fr.maboite.correction.service.RoleService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/commandes")
@Produces(MediaType.APPLICATION_JSON)
public class CommandeController {
	
	private CommandeService commandeService = new CommandeService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandes() {
		System.out.println("getRoles est appelée");
		List<Commande> commandes = this.commandeService.get();
		
		if(commandes == null || commandes.stream().count() <= 0)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(commandes).build();	
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommande(@PathParam("id") Integer id) {
		
		System.out.println("getCommande est appelée avec l'id : " + id);
		Commande commande = this.commandeService.get(id);
		
		if (commande == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(commande).build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Commande commande) {
		
		System.out.println("save est appelée");
		
		Commande commandeStored = this.commandeService.save(commande);
		
		if(commandeStored == null || commandeStored.getIdCommand() <= 0)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(commandeStored).build();
	}
	
}
