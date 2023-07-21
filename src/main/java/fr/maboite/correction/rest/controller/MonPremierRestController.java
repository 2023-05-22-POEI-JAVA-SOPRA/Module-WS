package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/voitures")
public class MonPremierRestController {

	@GET
	@Path("/id/{jaxRsId}")
	public String getMethod(@PathParam("jaxRsId") String id) { // URL que traite cette méthode :
		// URL application + URL de la classe + URL de la méthode
		
		System.out.println("ok voitures " + id) ;
		return "ok voitures " + id ;
	}
	@DELETE
	@Path("/id/{jaxRsId}"  )
	public String deleteMethod(@PathParam("jaxRsId") String id) { // URL que traite cette méthode :
		// URL application + URL de la classe + URL de la méthode
		
		System.out.println("delete voitures " + id) ;
		return "delete voitures " + id ;
	}
	


}
