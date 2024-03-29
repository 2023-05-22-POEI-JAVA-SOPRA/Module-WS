package fr.maboite.correction.rest.controller;

import jakarta.validation.Valid;
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
	@Path("/{jaxRsId}")
	public String maPremiereMethode(@PathParam("jaxRsId") Integer id) { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
			System.out.println("maPremiereMethode est appelée avec l'id : " + id);
		return "ok";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public VoiturePojo sauvegarde(@Valid VoiturePojo voiturePojo) {
		System.out.println("La voiture : " + voiturePojo.getId() + " a été passée par POST ");
		voiturePojo.setName("Voiture postée");
		return voiturePojo;
	}

}
