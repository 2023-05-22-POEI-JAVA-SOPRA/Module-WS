package fr.maboite.correction.rest.pojo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.User;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.constraints.NotNull;



public class CommandRestDto {
	private Integer idCommand;
	private UserRestDto userRestDto;
	@NotNull @JsonbDateFormat("yyyy-MM-dd")
	private Date commandDate;
	
	
	public CommandRestDto() {
		super();
	}

	

	public CommandRestDto(Date commandDate) {
		super();
		this.commandDate = commandDate;
	}



	public CommandRestDto(UserRestDto userRestDto, Date commandDate) {
		super();
		this.userRestDto = userRestDto;
		this.commandDate = commandDate;
	}
	
	public CommandRestDto(Command command) {
		idCommand = command.getIdCommand();
		userRestDto = new UserRestDto(command.getUser());
		commandDate = command.getCommandDate();
	}

	public Command convertToCommand() {
		return new Command(userRestDto.convertToUser(), commandDate);
	}
	
	public Command convertToCommand(User user) {
		return new Command(user, commandDate);
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
	
//	private Integer idCommand;
//	private Integer idUser;
//	private Date commandDate;
//	
//	
//	public CommandRestDto() {
//		super();
//	}
//
//
//	public CommandRestDto(Integer idUser, Date commandDate) {
//		super();
//		this.idUser = idUser;
//		this.commandDate = commandDate;
//	}
//	
//	public CommandRestDto(Command command) {
//		idUser = command.getUser().getIdUser();
//		commandDate = command.getCommandDate();
//	}
//
//	public Command convertToCommand(User user) {
//		return new Command(user , commandDate);
//	}
//	
//
//	public Integer getIdCommand() {
//		return idCommand;
//	}
//
//
//	public Integer getIdUser() {
//		return idUser;
//	}
//
//
//	public Date getCommandDate() {
//		return commandDate;
//	}
//
//
//	public void setIdCommand(Integer idCommand) {
//		this.idCommand = idCommand;
//	}
//
//
//	public void setIdUser(Integer idUser) {
//		this.idUser = idUser;
//	}
//
//
//	public void setCommandDate(Date commandDate) {
//		this.commandDate = commandDate;
//	}
//	
//	public static List<CommandRestDto> commandsToCommandsRestDtos(List<Command> commands) {
//		List<CommandRestDto> list = new ArrayList<CommandRestDto>();
//		for (Command command : commands) {
//			list.add(new CommandRestDto(command));
//		}
//		return list;
//	}
//	
	
}
