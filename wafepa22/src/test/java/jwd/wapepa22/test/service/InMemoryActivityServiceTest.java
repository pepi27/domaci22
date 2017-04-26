package jwd.wapepa22.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jwd.wafepa22.model.Activity;
import jwd.wafepa22.service.ActivityService;
import jwd.wafepa22.service.impl.InMemoryActivityService;

public class InMemoryActivityServiceTest {

private ActivityService activityService = null;

	
	@Before
	public void setUp(){
		activityService = new InMemoryActivityService();
		
		List<Activity> previousActivs = new ArrayList<>(); 
		previousActivs.add(new Activity("Running"));
		previousActivs.add(new Activity("Swimming"));
		previousActivs.add(new Activity("Dancing"));
		previousActivs.add(new Activity("Rowing"));
		
		activityService.save(previousActivs);
		
		
//    	### Umesto metode moze se proveriti ovako nece uspeti test sa velicnom liste aktivnosti ###
		
//		List<Long> ids = new ArrayList<>();
//		ids.add(3L);
//		ids.add(4L);
//		
//		activityService.remove(ids);
		
	}
	
	@Test
	public void testFindOne(){
		Activity activity = activityService.findOne(2L);
		
		Assert.assertNotNull(activity);
		Assert.assertEquals("Swimming", activity.getName());
	}
	
	@Test
	public void testFindAll(){
		List<Activity> activities = 
				activityService.findAll();
		
		Assert.assertEquals(4, activities.size());
		
	}
	
	@Test 
	public void testFindByName() {
		List<Activity> acts = new ArrayList<>(); 
		acts.add(activityService.findOne(1L));
		acts.add(activityService.findOne(2L));
		
		acts = activityService.findByName("Running");
		Assert.assertNotNull(acts); 
		Assert.assertEquals("Running", acts.get(0).getName());
	}
	
	@Test 
	public void testAddList() {
								
		
	}
	
	@Test
	public void testRemoveList() {
		List<Long> ids = new ArrayList<>();
		ids.add(3L);
		ids.add(4L);
		
		activityService.remove(ids);
		
		List<Activity> activities = 
				activityService.findAll();
		
		Assert.assertEquals(2, activities.size());
	}
}
