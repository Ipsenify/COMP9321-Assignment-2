package edu.unsw.comp9321.assign2.notifications;

import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

public class AuctionHaltedByAdminEmail extends Email {

	public AuctionHaltedByAdminEmail(User user, Auction auction) {
		super(user);
		this.setSubject("Auction \"" + auction.getTitle() + "\" has been halted");
		this.setText("Hi " + user.getFullName() + ",<br />"
				+ "Your auction \""
				+ auction.getTitle()
				+ "\" has been hated for breeching the iBuy T&C's");
	}
}
	