package fr.maboite.correction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.entity.User;

public class UserServiceTest {

	private UserService userService = new UserService();

	
	@Test
	public void testSave() throws Exception {

		// Arrange
		User user = new User();

		// Act
		User savedUser = this.userService.save(user);

		// Assert
		Assertions.assertNotNull(savedUser);
		Assertions.assertNotNull(savedUser.getIdUser());

	}


}