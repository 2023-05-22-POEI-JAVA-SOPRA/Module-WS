package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.controller.rest.pojo.VoiturePojo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public VoiturePojo save(@Valid VoiturePojo voiturePojo)
	{
		
		System.out.println("Voiture created : " + voiturePojo.getId() + " passed by POST");
//		voiturePojo.setName("Voiture ");
		return voiturePojo;
	}
	
	
	


}
