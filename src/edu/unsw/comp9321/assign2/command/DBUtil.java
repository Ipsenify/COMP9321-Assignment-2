package edu.unsw.comp9321.assign2.command;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.unsw.comp9321.assign2.dao.UserDAO;
import edu.unsw.comp9321.assign2.service.UserService;

public class DBUtil {
	
	private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	public static UserService getUserService(){
		return (UserService) ctx.getBean("userService");
	}
	
	public static UserDAO getUserDAO(){
		return (UserDAO) ctx.getBean("userDAO");
	}
}
