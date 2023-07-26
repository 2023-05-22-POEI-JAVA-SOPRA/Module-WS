package fr.maboite.correction.rest.pojo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.User;


public class CommandRestDto {
	private Integer idCommand;
	private UserRestDto userRestDto;
	private Date commandDate;
	
	
	public CommandRestDto() {
		super();
	}


	public CommandRestDto(UserRestDto userRestDto, Date commandDate) {
		super();
		this.userRestDto = userRestDto;
		this.commandDate = commandDate;
	}
	
	public CommandRestDto(Command command) {
		userRestDto = new UserRestDto(command.getUser());
		commandDate = command.getCommandDate();
	}

	public Command convertToCommand() {
		return new Command(userRestDto.convertToUser(), commandDate);
	}
	

	public Integer getIdCommand() {
		return idCommand;
	}


	public UserRestDto getUserRestDto() {
		return userRestDto;
	}


	public Date getCommandDate() {
		return commandDate;
	}


	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}


	public void setUserRestDto(UserRestDto userRestDto) {
		this.userRestDto = userRestDto;
	}


	public void setCommandDate(Date commandDate) {
		this.commandDate = commandDate;
	}
	
	public static List<CommandRestDto> commandsToCommandsRestDtos(List<Command> commands) {
		List<CommandRestDto> list = new ArrayList<CommandRestDto>();
		for (Command command : commands) {
			list.add(new CommandRestDto(command));
		}
		return list;
	}
	
	
	
}
