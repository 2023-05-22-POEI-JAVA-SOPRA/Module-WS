package fr.maboite.correction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.entity.CommandLine;

public class CommandLinesTest {
	
	CommandLineService service = new CommandLineService();
	
	@Test
	public void getbyid_CommandLine_with_non_existing_id() {
		assertNull(service.getById(55));
	}
	
	@Test
	public void getById_CommandLine_with_existing_id() {
		CommandLine uTest = new CommandLine(9, 1, 20);
		assertEquals(uTest, service.getById(6));
	}
	

}
