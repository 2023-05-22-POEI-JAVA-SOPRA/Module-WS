//package fr.maboite.correction.service;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import fr.maboite.correction.jpa.entity.Role;
//
//
//public class RoleServiceTest {
//
//	private static RoleService roleService;
//
//	@BeforeAll
//	public static void beforeAll() {
//		createRoles();
//		roleService = new RoleService();
//	}
//
//	public static void createRoles() {
//
//		List<Role> roles = Arrays.asList(new Role("client"), new Role("admin"), new Role("stockManager"),
//				new Role("CEO"), new Role("CTO"));
//		for (Role role : roles) {
//			roleService.save(role);
//		}
//	}
//
//	@ParameterizedTest()
//	@CsvSource(value = { "Vip", "HR", "manager" }, delimiter = ',')
//	public void test_Save_Role(String r) throws Exception {
//
//		// Arrange
//		Role role = new Role(r);
//
//		// Act
//		Role savedRole = roleService.save(role);
//
//		// Assert
//		Assertions.assertNotNull(savedRole);
//		Assertions.assertNotNull(savedRole.getId());
//		assertEquals(savedRole, role);
//	}
//
//	@ParameterizedTest()
//	@CsvSource(value = { "0,-1,-2,-4564" }, delimiter = ',')
//	public void testGetBy_with_id_negative_or_equal_to_should_return_null(Integer Id) throws Exception {
//		Role role = roleService.get(Id);
//		assertNull(role);
//	}
//
//	@Test
//	public void testGetBy_with_id_positive_out_of_bounds_should_return_null() throws Exception {
//		Random rn = new Random();
//		Integer id = rn.nextInt(10, 12) * 10000;
//		Role role = roleService.get(id);
//		assertNull(role);
//
//	}
//
//	@ParameterizedTest()
//	@CsvSource(value = { "admin", "test", "superadmin" }, delimiter = ',')
//	public void testGetBy_with_valid_id_should_return_user(String r)
//			throws Exception {
//		// Arrange
//		Role role = new Role(r);
//		Role savedRole = roleService.save(role);
//		Role roleToGet = roleService.get(savedRole.getId());
//		// Assert
//		assertNotNull(roleToGet);
//		assertEquals(savedRole.getId(), roleToGet.getId());
//		assertEquals(savedRole.getRoleName(), roleToGet.getRoleName());
//
//	}
//
//	@Test
//	public void test_find_all() throws Exception {
//
//		List<Role> roles = roleService.findAll();
//		assertNotNull(roles);
//		assertTrue("Roles list is null", roles.size() > 0);
//	}
//
//}
