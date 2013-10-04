package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class UpdateProfileForm extends AbstractSynchronizedForm {
	
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
		user.setFirstName(param("firstName"));
		user.setLastName(param("lastName"));
		user.setEmail(param("email"));
		user.setNickName(param("nickName"));
		user.setYearOfBirth(Helper.toInt(param("yearOfBirth")));
		user.setFullAddress(param("fullAddress"));
		String creditCardNumber = param("creditCardNumber");
		if(creditCardNumber != null && !creditCardNumber.isEmpty())
			user.setCreditCardNumber(param("creditCardNumber"));
		
		// Update database
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
