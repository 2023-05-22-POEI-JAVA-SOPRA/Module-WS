package fr.maboite.correction.rest.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * Mappe les exceptions de type ConstraintViolationException
 * pour en faire des réponses HTTP correctes
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(final ConstraintViolationException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(prepareMessage(exception)).type(MediaType.APPLICATION_JSON)
				.build();
	}

	private List<JSONFormatPojo> prepareMessage(ConstraintViolationException exception) {
		List<JSONFormatPojo> list = new ArrayList<>();
		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
			list.add(new JSONFormatPojo("" + cv.getPropertyPath(),"" + cv.getInvalidValue(), "" + cv.getMessage()));
		}
		return list;
	}
	
	public record JSONFormatPojo(String propertyPath, String invalidValue, String message) {}
}