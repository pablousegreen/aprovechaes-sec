package com.aprovechaessec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aprovechaessec.entity.Task;
import com.aprovechaessec.entity.User;
import com.aprovechaessec.services.TaskService;
import com.aprovechaessec.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AprovechaesSecApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Before
	public void InitDB() {
		{
			User user = new User("testUser@mail.com", "testUser", "123456");
			userService.creatUser(user);
		}
		{
			User user = new User("testAdmin@mail.com", "testAdmin", "123456");
			userService.creatUser(user);
		}
		{
			
			User user = userService.findOne("testUser@mail.com");
			Task userTask = new Task("03/01/2018", "00:01", "11:00", "You need to work today", user);
			taskService.addTask(userTask);
		}
		{
			User user = userService.findOne("testAdmin@mail.com");
			Task userTask = new Task("03/01/2018", "00:01", "11:00", "You need to work today", user);
			taskService.addTask(userTask);
		}
		
	}
	
//	@Test
//	public void testUser() {
//		User user = userService.findOne("testUser@mail.com");
//		assertNotNull(user);
//		User admin = userService.findOne("testAdmin@mail.com");
////		assertEquals(admin.getEmail(), "testAdmin@mail.com");
//		assertNotNull(admin);
//	}
	
	@Test
	public void testTask() {
		User user = userService.findOne("testUser@mail.com");
		List<Task> tasks = taskService.findUserTask(user);
		assertNotNull(tasks);
		
		User admin = userService.findOne("testAdmin@mail.com");
		tasks = taskService.findUserTask(admin);
		assertNotNull(tasks);
	}

}
