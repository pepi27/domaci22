package jwd.wafepa22.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa22.model.User;
import jwd.wafepa22.service.UserService;
import jwd.wafepa22.service.impl.InMemoryUserService;

@RestController
@RequestMapping(value="/api/users")
public class ApiUserController {
	@Autowired
	public UserService userService = new InMemoryUserService();
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>getUsers() {
		
		System.out.println("getUsers() method");
		List<User> users = userService.getAllUsers();
		
		return new ResponseEntity<>( users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		System.out.println("getUser() method");
		User user = userService.getUser(id);
		
		if(user == null) {
			return  new ResponseEntity<>( user, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>( user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> saveUser(@PathVariable Long id) {
		
		User user = userService.saveUser(new User(id, "miki@gmail.rs", "Miki", "Predrag", "Manojlovic"));
		
		return new ResponseEntity<> ( user, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<User> add(@RequestBody User postedActivity) {
		System.out.println("postUser() method");
		User persisted = userService.saveUser(postedActivity);
		
		return new ResponseEntity<User>(persisted, HttpStatus.CREATED);
		
	}
	
	@PostConstruct
	public void init(){
		userService.saveUser(new User("petarsimic@yajoo", "pepi", "petar", "simic"));
		userService.saveUser(new User("mikimikic@yajoo", "miki", "miki", "mikic"));
		
	}
}
