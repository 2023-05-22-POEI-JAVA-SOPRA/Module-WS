package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.VoiturePojo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/voitures")
@Produces(MediaType.APPLICATION_JSON)
public class MonPremierRestController {
	
	@GET
	@Path("/{javRsId}")
	public String maPremiereMethode(@PathParam("javRsId") int id) { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
		System.out.println("Appel avec id: " + id);
		return "ok";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public VoiturePojo sauvegarde(VoiturePojo voiturePojo) {
		System.out.println("La voiture: " + voiturePojo.getId() + " a ete postee");
		return voiturePojo;
	}

}
