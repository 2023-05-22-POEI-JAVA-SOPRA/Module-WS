package fr.maboite.correction.rest.pojo;

import java.util.ArrayList;
import java.util.List;

public class ErrorPojo {

	private List<ErrorLinePojo> errorLines = new ArrayList<>();

	public List<ErrorLinePojo> getErrorLines() {
		return errorLines;
	}

	public void setErrorLines(List<ErrorLinePojo> errorLines) {
		this.errorLines = errorLines;
	}

}
