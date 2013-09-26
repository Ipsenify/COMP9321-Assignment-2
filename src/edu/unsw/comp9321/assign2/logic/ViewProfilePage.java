package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.model.User;

public class ViewProfilePage extends AbstractPage {

	@Override 
	public String processView() throws ServletException, IOException
	{
		User user = context.getUser();
		request.setAttribute("user", user);
		return "user/view.jsp";
	}
}
