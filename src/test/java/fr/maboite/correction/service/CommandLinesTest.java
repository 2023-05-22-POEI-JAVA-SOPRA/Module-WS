package fr.maboite.correction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.entity.Article;
import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.CommandLine;

public class CommandLinesTest {
	
	CommandLineService service = new CommandLineService();
	
	@Test
	public void getbyid_CommandLine_with_non_existing_id() {
		assertNull(service.getById(55));
	}
	
	@Test
	public void getById_CommandLine_with_existing_id() {
		Command command = new CommandService().getById(9);
		Article article = new ArticleService().getById(1);
		CommandLine uTest = new CommandLine(6,article,command,20);
		assertEquals(uTest, service.getById(6));
	}
	

}
