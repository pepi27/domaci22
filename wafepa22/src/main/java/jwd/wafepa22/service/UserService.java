package jwd.wafepa22.service;

import java.util.List;

import jwd.wafepa22.model.User;


public interface UserService {

	User getUser(Long id);
	List<User> getAllUsers();
	User saveUser(User user);
	void deleteUser(Long id);
}
