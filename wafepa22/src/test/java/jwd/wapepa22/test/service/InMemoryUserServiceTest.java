package jwd.wapepa22.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jwd.wafepa22.model.User;
import jwd.wafepa22.service.UserService;
import jwd.wafepa22.service.impl.InMemoryUserService;

public class InMemoryUserServiceTest {

	private UserService userService = null; 
	
	@Before
	public void setup() {
		
		userService = new InMemoryUserService();
		
		User u1 = new User("petar2simic@gmail.com", "pepi", "Petar", "Simic");
		User u2 = new User("milosjovanovic@gmail.com", "milos", "Milos", "Jovanovic");
		userService.saveUser(u1);
		userService.saveUser(u2);
		
	}
	
	@Test
	public void testFindUser() {
		User user1 = userService.getUser(1L);
		Assert.assertEquals("pepi", user1.getPassword());
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> users = userService.getAllUsers();
		Assert.assertEquals(2, users.size());
	}
	
	@Test
	public void testDeleteUser() {
		User u = userService.getUser(1L); 
		userService.deleteUser(u.getId());
		List<User> users = userService.getAllUsers();
		Assert.assertEquals(1, users.size());
	}
}
