package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;
import java.util.Random;

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
			if(user != null){
				user.setConfirmationUrl(null);
				user.setStatus(UserStatus.VERIFIED);
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
		Random random = new Random();
		double randomNum = random.nextDouble();
		Double result = 10 + (randomNum * (1000000000));
		String url = Helper.encrypt(result.toString());
		// Check url doesn't exist
		UserService service = DBUtil.getUserServiceWithoutRefresh();
		if(service.findByConformation(url) != null){
			return generateUrl();
		}
		return url;
	}
}
