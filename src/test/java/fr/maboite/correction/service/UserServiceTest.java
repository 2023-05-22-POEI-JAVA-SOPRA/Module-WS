package fr.maboite.correction.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import fr.maboite.correction.jpa.entity.User;

public class UserServiceTest {

	private static  UserService userService;

	@BeforeAll
	public static void befAll() {
		 userService = new UserService();
		createUsers();
	}
	

	public static void createUsers() {

		List<User> users = Arrays.asList(new User("Anderson", "Neo", 0), new User("Skywalker", "Luke", 0),
				new User("Plissken", "Snake", 0), new User("Ripley", "Ellen", 0), new User("Bond", "James", 0));
		for (User user : users) {
			userService.save(user);
		}
	}

	@ParameterizedTest()
	@CsvSource(value = { "Login,p@ssWord,0", "Admin,Admin,200", "SuperAdmin,password123,150" }, delimiter = ',')
	public void test_Save_User(String s1, String s2, Integer connectionNumber) throws Exception {

		// Arrange
		User user = new User(s1, s2, connectionNumber);

		// Act
		User savedUser = userService.save(user);

		// Assert
		Assertions.assertNotNull(savedUser);
		Assertions.assertNotNull(savedUser.getIdUser());
		assertEquals(savedUser, user);
	}

	@ParameterizedTest()
	@CsvSource(value = { "0,-1,-2,-4564" }, delimiter = ',')
	public void testGetBy_with_id_negative_or_equal_to_should_return_null(Integer Id) throws Exception {
		User user = userService.get(Id);
		assertNull(user);
	}

	@Test
	public void testGetBy_with_id_positive_out_of_bounds_should_return_null() throws Exception {
		Random rn = new Random();
		Integer id = rn.nextInt(10, 12) * 10000;
		User user = userService.get(id);
		assertNull(user);

	}

	@ParameterizedTest()
	@CsvSource(value = { "Login,p@ssWord,0", "Admin,Admin,200", "SuperAdmin,password123,150" }, delimiter = ',')
	public void testGetBy_with_valid_id_should_return_user(String s1, String s2, Integer connectionNumber)
			throws Exception {
		// Arrange
		User user = new User(s1, s2, connectionNumber);
		// Act
		User savedUser = userService.save(user);
		User userToGet = userService.get(savedUser.getIdUser());
		// Assert
		assertNotNull(userToGet);
		assertEquals(savedUser.getConnectionNumber(), userToGet.getConnectionNumber());
		assertEquals(savedUser.getLogin(), userToGet.getLogin());
		assertEquals(savedUser.getIdUser(), userToGet.getIdUser());
		assertEquals(savedUser.getPassword(), userToGet.getPassword());

	}

	@Test
	public void test_find_all() throws Exception {

		List<User> users = userService.findAll();
		assertNotNull(users);
		assertTrue("Users list is null", users.size() > 0);
	}

	@Test
	public void test_delete_all() throws Exception {
			List<User> users = userService.findAll();
			assertNotNull(users);
			assertTrue(users.size() >0);
			assertTrue(userService.deleteAll());
			assertNull(userService.findAll());
			
	}

}