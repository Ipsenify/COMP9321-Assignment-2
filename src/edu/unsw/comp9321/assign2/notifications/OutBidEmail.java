package edu.unsw.comp9321.assign2.notifications;

import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

public class OutBidEmail extends Email {

	public OutBidEmail(User user, Auction auction) {
		super(user);
		this.setSubject("Your bid on \"" + auction.getTitle() + "\" has been outbid");
		this.setText("Hi " + user.getFullAddress() + "<br />"
				+ "Your bid on \"" + auction.getTitle() + "\" has been outbid");
	}
}
	