package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class ChangePasswordForm extends AbstractSynchronizedForm {
	
	@Override
	public String processView() throws ServletException, IOException
	{
		return "user/changepassword.jsp";
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException
	{
		String currentPassword = param("currentpassword");
		UserService service = DBUtil.getUserService();
		
		User user = service.findByCredentials(context.getUser().getUserName(), Helper.encrypt(currentPassword));
		if(user != null){
			user.setPassword(Helper.encrypt(param("newpassword")));
			// Update database
			try{
				service.merge(user);
				// Update current user
				context.reloadUser();
			}catch(Exception e){
				// Unable to update
				setError("An error occured while trying to update the password.");
				return "user/changepassword.jsp";
			}
		}else{
			// Throw an error, password incorrect
			setError("The current password entered is not correct.");
			return "user/changepassword.jsp";
		}
		
		return "redirect:user/view";
	}
}
