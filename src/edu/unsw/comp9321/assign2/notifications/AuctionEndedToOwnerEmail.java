package edu.unsw.comp9321.assign2.notifications;

import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

public class AuctionEndedToOwnerEmail extends Email {

	public AuctionEndedToOwnerEmail(User user, Auction auction) {
		super(user);
		this.setSubject("Auction \"" + auction.getTitle() + "\" has ended");
		this.setText("Hi " + user.getFullName() + ",<br />"
				+ "Your auction \""
				+ auction.getTitle()
				+ "\" has finished with the highest bid meeting the reserve price, congratulations!");
	}
}
	