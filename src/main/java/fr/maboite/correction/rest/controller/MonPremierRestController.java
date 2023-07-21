package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/voitures")
public class MonPremierRestController {
	
	@GET
	@Path("/{javRsId}")
	public String maPremiereMethode(@PathParam("javRsId") int id) { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
		System.out.println("Appel avec id: " + id);
		return "ok";
	}

}
