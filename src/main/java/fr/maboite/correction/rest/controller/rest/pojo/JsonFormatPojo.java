package fr.maboite.correction.rest.controller.rest.pojo;

public class JsonFormatPojo {

	
	public String propertyPath;
	
	public String invalidValue;
	
	public String message;

	public String getPropertyPath() {
		return propertyPath;
	}

	public JsonFormatPojo(String propertyPath, String invalidValue, String message) {
		super();
		this.propertyPath = propertyPath;
		this.invalidValue = invalidValue;
		this.message = message;
	}

	public void setPropertyPath(String propertyPath) {
		this.propertyPath = propertyPath;
	}

	public String getInvalidValue() {
		return invalidValue;
	}

	public void setInvalidValue(String invalidValue) {
		this.invalidValue = invalidValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
