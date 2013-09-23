package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.unsw.comp9321.assign2.dao.UserDAO;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;

public class RegistrationForm extends AbstractForm {

	private UserDAO userDAO;
	
	@Override
	public String processView() throws ServletException, IOException {
		
		/*
		User user = new User();
		
		user.setUserName("test");
		user.setPassword("TEST");
		
		user.setFirstName("Hello");
		user.setLastName("World");
		
		request.setAttribute("user", user);
		
		UserDAO dao = DAOFactory.getInstance().getUserDAO();
		User user2 = dao.find((long)2);
		System.out.println("User2: " + user2.getUserName());
		
		dao.save(user);
		
		//dao.save(user);
		
		dao.save(user);
		*/
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("userService");
		
		/*User user = new User();
		user.setLastvisit_at(new Date());
		user.setUserName("Hellooo");
		user.setFirstName("What up");
		user.setLastName("Elhusseini");
		user.setEmail("whatup.");
		user.setFullAddress("What up");
		user.setCreated_at(new Date());
		user.setNickName(" ");
		user.setPassword("asdasdA");
		user.setStatus(0);
		user.setYearOfBirth(1990);
		user.setCreditCardNumber("1212");
		service.persist(user);*/
		
		//User user = service.findById((long)1);
		//user.setLastName("Elhusseini");
		
		//service.merge(user);
		
		//System.out.println("Username: " + user.getUserName());
		//System.out.println("Last visited: " + user.getLastvisit_at());
		
		ctx.close();
		return "site/register.jsp";
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException {
		
		return "";
	}
}
