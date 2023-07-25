package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.ErrorLinePojo;
import fr.maboite.correction.rest.pojo.ErrorPojo;
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

	private ErrorPojo prepareMessage(ConstraintViolationException exception) {
		ErrorPojo errorPojo = new ErrorPojo();
		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
			ErrorLinePojo errorLine = new ErrorLinePojo();
			errorLine.setPropertyPath(cv.getPropertyPath().toString());
			if (cv.getInvalidValue() != null) {
				errorLine.setValue(cv.getInvalidValue().toString());
			}
			errorLine.setMessage(cv.getMessage());
			errorPojo.getErrorLines().add(errorLine);
		}
		return errorPojo;
	}
}