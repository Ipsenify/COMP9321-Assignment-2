package edu.unsw.comp9321.assign2.notifications;

import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

public class AuctionEndedActionRequiredToOwnerEmail extends Email {

	public AuctionEndedActionRequiredToOwnerEmail(User user, Auction auction) {
		super(user);
		this.setSubject("Auction \"" + auction.getTitle() + "\" has ended");
		this.setText("Hi " + user.getFullName() + ",<br />"
				+ "The highest bid for your auction \""
				+ auction.getTitle()
				+ "\" did not meet the reserve price you set <br />"
				+ "please login to your account to accept/reject the highest offer.");
	}
}
	