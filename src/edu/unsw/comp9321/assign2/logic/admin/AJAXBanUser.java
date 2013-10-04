package edu.unsw.comp9321.assign2.logic.admin;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.model.User.UserStatus;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AJAXBanUser extends AdminAction {

	@Override
	public String processSubmit() throws ServletException, IOException {
		Long id = Helper.toLong(param("id"));

		UserService service = DBUtil.getUserService();
		User user = service.findById(id);

		// Change Status
		user.setUserStatus(UserStatus.BANNED);
		service.merge(user);
		
		return "";
	}
}