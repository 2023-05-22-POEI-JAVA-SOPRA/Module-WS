package fr.maboite.correction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.entity.User;

public class UserServiceTest {
	UserService service = new UserService();
	
	@Test
	public void getbyid_user_with_non_existing_id() {
		assertNull(service.getById(1000000000));
	}
	
	@Test
	public void getById_user_with_existing_id() {
		User uTest = new User(2, "paul@paul.com", "motdepasse", 655615546);
		assertEquals(uTest, service.getById(2));
	}
	
	
//	@Test
//	public void delete_user_with_existing_id() {
//		assertEquals(service.delete(4), false);
//	}
	
	
	@Test
	public void delete_user_with_non_existing_id() {
		assertEquals(service.delete(1000000000), false);
	}
	
	@Test
	public void create_user_with_null_login() {
		User u = new User(null, "123456", 5162651);
		assertFalse(service.create(u));
	}
	
	@Test
	public void create_user_with_null_password() {
		User u = new User("aaa@bb.com", null, 5162651);
		assertFalse(service.create(u));
	}
	
	@Test
	public void create_user_with_null_connectionNumber() {
		User u = new User("aaa@bb.com", "123456", null);
		assertFalse(service.create(u));
	}

	@Test
	public void create_user_with_login_size_sup_to_20() {
		User u = new User("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa@bb.com", "12345678", 5162651);
		assertFalse(service.create(u));
	}
	
	@Test
	public void create_user_with_password_size_sup_to_20() {
		User u = new User("aaaaa@bb.com", "12345678888888888888888888888888888888888888888", 5162651);
		assertFalse(service.create(u));
	}
	
	@Test
	public void create_valid_user() {
		User u = new User("test@test.com", "testtest", 5162651);
		assertTrue(service.create(u));
	}
}
