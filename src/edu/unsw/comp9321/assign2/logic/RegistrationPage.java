package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.model.User;

public class RegistrationPage extends AbstractPage {

	@Override
	public String processView() throws ServletException, IOException {
		if (!context.isAuthenticated()) {
			User user = new User();
			request.setAttribute("user", user);
			return "site/register.jsp";
		} else {
			// Redirect to view
			return "redirect:user/view";
		}
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException {
		User user = new User();
		user.setUserName(param("username"));
		user.setPassword(param("pass"));
		user.setEmail(param("email"));
		
		request.setAttribute("user", user);
		return "user/register.jsp";
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
}
