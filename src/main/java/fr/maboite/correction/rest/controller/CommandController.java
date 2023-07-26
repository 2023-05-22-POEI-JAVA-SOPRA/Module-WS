package fr.maboite.correction.rest.controller;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.rest.pojo.CommandRestDto;
import fr.maboite.correction.service.CommandService;
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
	public List<CommandRestDto> getCommands(){
		System.out.println("getcommands est appelé ");
		List<Command> commands = this.commandService.findAll();
		List<CommandRestDto> commandsDto = new ArrayList<CommandRestDto>();
		for(Command command:commands) {
			CommandRestDto commandRestDto = new CommandRestDto(command);
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
	
	@POST
	public CommandRestDto save(CommandRestDto commandPojoDto) {
		System.out.println("save est appelée");
		Command savedCommand = this.commandService.save(commandPojoDto.toCommand());
		return new CommandRestDto(savedCommand);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteCommands(@PathParam("id") Integer id) {
		System.out.println("deletecommands est appelée avec l'id : " + id);
		this.commandService.delete(id);
	}
	
	
	

}
