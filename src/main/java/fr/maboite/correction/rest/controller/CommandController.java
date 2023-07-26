package fr.maboite.correction.rest.controller;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.rest.pojo.CommandRestDto;
import fr.maboite.correction.rest.pojo.CommandRestDto2;
import fr.maboite.correction.service.CommandService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/commands")
@Produces(MediaType.APPLICATION_JSON)
public class CommandController {
	
	private CommandService commandService = new CommandService();
	
	@GET
	public List<CommandRestDto2> getCommands(){
		System.out.println("getcommands est appelé ");
		List<Command> commands = this.commandService.findAll();
		List<CommandRestDto2> commandsDto = new ArrayList<>();
		for(Command command:commands) {
			CommandRestDto2 commandRestDto = new CommandRestDto2(command);
			commandsDto.add(commandRestDto);
		}
		return commandsDto;
	}
	
	@GET
	@Path("/{id}")
	public CommandRestDto getCommands(@PathParam("id") Integer id) {
		System.out.println("getcommands est appelée avec l'id : " + id);
		Command command = this.commandService.get(id);
		if (command == null) {
			return null;
		}
		return new CommandRestDto(command);
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public CommandRestDto save(CommandRestDto commandPojoDto) {
//		System.out.println("save est appelée");
//		Command savedCommand = this.commandService.save(commandPojoDto.toCommand());
//		return new CommandRestDto(savedCommand);
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public CommandRestDto2 save(CommandRestDto2 commandPojoDto) {
		System.out.println("save est appelée 2");
		Command savedCommand = this.commandService.save(commandPojoDto.toCommand());
		return new CommandRestDto2(savedCommand);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteCommands(@PathParam("id") Integer id) {
		System.out.println("deletecommands est appelée avec l'id : " + id);
		this.commandService.delete(id);
	}
	
	
	

}
