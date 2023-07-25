package fr.maboite.correction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
	static UserService service;
	
	public static void beforeAll() {
		service = new UserService();
	}
	
	@Test
	public void delete_user_with_existing_id() {
		assertEquals(service.delete(4), true);
	}
	
}
