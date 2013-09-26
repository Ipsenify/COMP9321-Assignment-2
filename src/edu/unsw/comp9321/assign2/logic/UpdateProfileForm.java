package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class UpdateProfileForm extends AbstractForm {
	
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
		UserService service = DBUtil.getUserService();
		User user = service.findById(context.getUserId());
		user.setFirstName(param("user.firstName"));
		user.setLastName(param("user.lastName"));
		user.setEmail(param("user.email"));
		//user.setNickName(param("user.nickName"));
		user.setYearOfBirth(Helper.toInt(param("user.yearOfBirth")));
		user.setFullAddress(param("user.fullAddress"));
		user.setCreditCardNumber(param("user.creditCardNumber"));
		
		try{
			service.merge(user);
			// Update current user
			context.reloadUser();
		}catch(Exception e){
			// Unable to update
			setError("An error occured while trying to update profile.");
			request.setAttribute("user", user);
			return "user/update.jsp";
		}
		return "redirect:user/view";
	}
}
