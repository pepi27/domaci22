package jwd.wafepa22.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jwd.wafepa22.model.User;
import jwd.wafepa22.service.UserService;

@Service
public class InMemoryUserService implements UserService{
	
	Map<Long, User> users = new HashMap<>();
	private Long nextId = 1L;

	@Override
	public User getUser(Long id) {
		return users.get(id);
	}

	@Override
	public List<User> getAllUsers() {
		return new ArrayList<>( users.values() ); 
	}

	@Override
	public User saveUser(User u) {
		if(u.getId() == null) {
			u.setId(nextId++);
		}
		users.put(u.getId(), u); 
		return u; 
	}

	@Override
	public void deleteUser(Long id) {
		if(! users.containsKey(id)) {
			throw new IllegalArgumentException("Tried to remove nonexistant");
		}
		users.remove(id); 
	}

}
