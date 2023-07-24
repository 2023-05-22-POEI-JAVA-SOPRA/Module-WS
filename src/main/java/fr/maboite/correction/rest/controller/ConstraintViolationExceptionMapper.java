package fr.maboite.correction.rest.controller;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.rest.controller.rest.pojo.JsonFormatPojo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * Mappe les exceptions de type ConstraintViolationException
 * pour en faire des réponses HTTP correctes
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

//	@Override
//	public Response toResponse(final ConstraintViolationException exception) {
//		return Response.status(Response.Status.BAD_REQUEST)
//				.entity(prepareMessage(exception)).type("text/plain")
//				.build();
//	}
	@Override
	public Response toResponse(final ConstraintViolationException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(prepareMessageToJson(exception))
//				.entity(prepareMessage(exception)).type("text/plain")
				.type(MediaType.APPLICATION_JSON).build();
	}

	private String prepareMessage(ConstraintViolationException exception) {
		StringBuilder msg = new StringBuilder();
		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
			msg.append(cv.getPropertyPath() + " with value " + cv.getInvalidValue() + " " + cv.getMessage() + "\n");
		}
		return msg.toString();
	}
	private List<JsonFormatPojo> prepareMessageToJson(ConstraintViolationException exception) {
		
		List<JsonFormatPojo> listJson = new ArrayList<JsonFormatPojo>();
		
		for(ConstraintViolation<?> cv : exception.getConstraintViolations())
		{
			JsonFormatPojo msg = new JsonFormatPojo(cv.getPropertyPath().toString(),cv.getInvalidValue().toString(),cv.getMessage());;
			listJson.add(msg);
		}
		return listJson;
	}

}