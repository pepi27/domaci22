package jwd.wafepa22.service;

import java.util.List;

import jwd.wafepa22.model.Activity;

public interface ActivityService {

	Activity findOne(Long id);
	List<Activity> findByName(String name); 
	Activity save (Activity activity); 
	
	List<Activity> findAll();
	List<Activity> save(List<Activity> activities);
	
	void remove(Long id); 
	void remove(List<Long> ids);  
}
