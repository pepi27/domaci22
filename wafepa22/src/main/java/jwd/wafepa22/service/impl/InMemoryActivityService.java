package jwd.wafepa22.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwd.wafepa22.model.Activity;
import jwd.wafepa22.service.ActivityService;

public class InMemoryActivityService implements ActivityService{

	private Map<Long, Activity> activities = new HashMap<>();
	private Long nextId = 1L;

	@Override
	public Activity findOne(Long id) {
		return activities.get(id);
	}

	@Override
	public List<Activity> findAll() {
		// List<Activity> list = new ArrayList<Activity>(activities.values());
		// return list;

		return new ArrayList<Activity>(activities.values());
	}

	@Override
	public Activity save(Activity activity) {
		if (activity.getId() == null) {
			activity.setId(nextId);
			nextId++;
		}
		activities.put(activity.getId(), activity);
		return activity;
	}

	@Override
	public void remove(Long id) {
		if (!activities.containsKey(id)) {
			throw new IllegalArgumentException("Tried to remove nonexistant");
		}
		activities.remove(id);
	}

	@Override
	public List<Activity> findByName(String name) {
		List<Activity> ret = new ArrayList<>();
		for (Activity a : activities.values()) {
			if (a.getName().equals(name))
				ret.add(a);
		}
		return ret;
	}

	@Override
	public List<Activity> save(List<Activity> actList) {
		for (Activity a : actList) {
			if (a.getId() == null) {
				a.setId(nextId++);
				activities.put(a.getId(), a);
			}
		}
		return new ArrayList<>( activities.values() );
	}

	@Override
	public void remove(List<Long> ids) {
		for(Long id : ids) {
			if (!activities.containsKey(id)) {
				throw new IllegalArgumentException("Tried to remove nonexistant");
			}
			activities.remove(id);
		}
	}
}
