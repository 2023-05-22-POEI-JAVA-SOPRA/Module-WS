package fr.maboite.controller;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.pojo.JsonFormatPojo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * Mappe les exceptions de type ConstraintViolationException pour en faire des
 * réponses HTTP correctes
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(final ConstraintViolationException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(prepareMessage(exception)).type("application/json")
				.build();
	}

	private List<JsonFormatPojo> prepareMessage(ConstraintViolationException exception) {
//		StringBuilder msg = new StringBuilder();
//		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
//			msg.append(cv.getPropertyPath() + " with value " + cv.getInvalidValue() + " " + cv.getMessage() + "\n");
//		}
//		return msg.toString();
		List<JsonFormatPojo> listJson = new ArrayList<>();
		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
			JsonFormatPojo msg = new JsonFormatPojo();
			msg.setPropertyPath("" + cv.getPropertyPath());
			msg.setInvalidValue("" + cv.getInvalidValue());
			msg.setMessage("" + cv.getMessage());
			listJson.add(msg);
		}
		return listJson;
	}
}