package edu.unsw.comp9321.assign2.logic.admin;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.model.User.UserStatus;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AJAXUnBanUser extends AdminAction {

	@Override
	public String processSubmit() throws ServletException, IOException {
		Long id = Helper.toLong(param("id"));

		UserService service = DBUtil.getUserService();
		User user = service.findById(id);
		if(user.getConfirmationUrl() != null && !user.getConfirmationUrl().isEmpty()){
			// Not verified
			user.setUserStatus(UserStatus.NOTVERIFIED);
		}else{
			user.setUserStatus(UserStatus.VERIFIED);
		}
		service.merge(user);
		
		return "";
	}
}