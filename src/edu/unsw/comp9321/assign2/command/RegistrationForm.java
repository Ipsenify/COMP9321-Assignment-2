package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.model.dao.UserDAO;

public class RegistrationForm extends AbstractForm {

	private UserDAO userDAO;
	
	@Override
	public String processView() throws ServletException, IOException {
		
		User user = new User();
		
		user.setFirstName("Hello");
		user.setLastName("World");
		
		request.setAttribute("user", user);
		
		return "site/register.jsp";
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException {
		
		return "";
	}
}
