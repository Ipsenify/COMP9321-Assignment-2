package edu.unsw.comp9321.assign2.notifications;

import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

public class BidEmail extends Email {

	public BidEmail(User user, Auction auction) {
		super(user);
		this.setSubject("Your bid on \"" + auction.getTitle() + "\" has been placed");
		this.setText("Hi " + user.getFullAddress() + "<br />"
				+ "Your bid on \"" + auction.getTitle() + "\" has been placed");
	}
}
	