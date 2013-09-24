package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.controller.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;

public class UpdateProfileForm extends AbstractPage{
	
	@Override
	public String processView() throws ServletException, IOException
	{
		User user = context.getUser();
		request.setAttribute("user", user);
		return "user/update.jsp";
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException
	{
		// update
		// update context.getUser
		
		return "";
	}
}
