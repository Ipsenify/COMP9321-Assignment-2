package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.util.Helper;

public class LoginForm extends AbstractForm {
	
	@Override
	public String processView() throws ServletException, IOException {
		request.setAttribute("redirectUrl", request.getParameter("redirectUrl"));
		return "site/login.jsp";
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String crypt = Helper.encrypt(password);
		
		if(username.isEmpty() && password.isEmpty()){
			return "site/login.jsp";
		}else{
			if(context.login(username, crypt)){
				String redirectUrl = request.getParameter("redirectUrl");
				if(redirectUrl != null && !redirectUrl.isEmpty()){
					return "redirect:" + redirectUrl.substring(1);
				}
				return "redirect:home";
			}else {
				setError("Wrong Username and password combination.");
				return "site/login.jsp";
			}
		}
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
}
