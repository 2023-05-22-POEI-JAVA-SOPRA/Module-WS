package fr.maboite.correction.validator;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RequestValidator {
	
	
	public boolean validateId(Integer id)
	{
		return id >= 0 ;
	}
	
	public Response response404()
	{
		
		 return Response.status(Response.Status.NOT_FOUND).entity("{'cause': 'not found id must be non negative or equal to 0'}").type(MediaType.APPLICATION_JSON).build();
	}
	
}
