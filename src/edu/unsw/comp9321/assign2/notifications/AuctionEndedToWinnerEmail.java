package edu.unsw.comp9321.assign2.notifications;

import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

public class AuctionEndedToWinnerEmail extends Email {

	public AuctionEndedToWinnerEmail(User user, Auction auction) {
		super(user);
		this.setSubject("Auction \"" + auction.getTitle() + "\" has ended");
		this.setText("Hi " + user.getFullName() + ",<br />"
				+ "Your bid for \""
				+ auction.getTitle()
				+ "\" has been successful, congratulations!");
	}
}
	