package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.model.User.UserStatus;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class ConfirmationService extends AbstractAction {
	
	@Override
	public String processView() throws ServletException, IOException
	{
		String confirm = param("id");
		if(confirm != null){
			UserService service = DBUtil.getUserService();
			User user = service.findByConformation(confirm);
			if(user != null && user.getUserStatus() != UserStatus.BANNED){
				user.setConfirmationUrl(null);
				user.setUserStatus(UserStatus.VERIFIED);
				service.merge(user);
				return "redirect:login";
			}
		}
		System.out.println(confirm);
		// TODO: redirect to error
		return "";
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
	
	public static String generateUrl(){
		String url = Helper.generateNext();
		UserService service = DBUtil.getUserServiceWithoutRefresh();
		if(service.findByConformation(url) != null){
			return generateUrl();
		}
		return url;
	}
}
