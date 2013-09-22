package edu.unsw.comp9321.assign2.command;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;

public class LoginForm extends AbstractForm {
	
	@Override
	public String processView() throws ServletException, IOException {
		
		User user = new User();
		user.setUserName("HELLO WORLD");
		UserService userService = DBUtil.getUserService();
		
		userService.persist(user);
		
		return "site/login.jsp";
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String crypt = cryptWithSHA(password);
		
		if(context.login(username, crypt)){
			setSuccess("Login Successful.");

			setWarning("Username is: " + context.getUser().getUserName());

			setWarning("Last Visited : " + context.getUser().getLastvisit_at());
			return "site/login.jsp";
		}else {
			// Set error.
			setError("Wrong Username and password combination.");
			return "site/login.jsp";
		}
	}

	private static String cryptWithSHA(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}
}
