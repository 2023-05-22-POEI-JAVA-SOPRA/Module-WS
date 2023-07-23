package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/voitures")
public class MonPremierRestController {
	
	@GET
	@Path("/{jaxRsId}")
	public String maPremiereMethode(@PathParam("jaxRsId") Integer id) { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
			System.out.println("maPremiereMethode est appelée avec l'id : " + id);
		return "ok";
	}

}
