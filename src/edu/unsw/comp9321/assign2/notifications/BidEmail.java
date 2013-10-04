package edu.unsw.comp9321.assign2.notifications;

import edu.unsw.comp9321.assign2.model.User;

public class BidEmail extends Email {

	public BidEmail(User user) {
		super(user);
		this.setSubject("[iBuy] Please verify your email '" + user.getEmail()
				+ "'");
		this.setText("Hey, we want to verify that you are indeed \""
				+ user.getUserName()
				+ "\".  If that's the case, please follow the link below: <br />"
				+ "<br />/user/confirm?id="
				+ user.getConfirmationUrl() + "<br />" + "<br />" + "If you're not "
				+ user.getUserName()
				+ " or didn't request verification you can ignore this email.");
	}
}
	