package edu.unsw.comp9321.assign2.notifications;

import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

public class AuctionEndedNotSoldToOwnerEmail extends Email {

	public AuctionEndedNotSoldToOwnerEmail(User user, Auction auction) {
		super(user);
		this.setSubject("Auction \"" + auction.getTitle() + "\" has ended");
		this.setText("Hi " + user.getFullName() + ",<br />"
				+ "No bids were placed for \""
				+ auction.getTitle()
				+ "\" sorry.");
	}
}
	