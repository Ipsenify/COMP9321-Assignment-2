package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.Auction.AuctionStatus;
import edu.unsw.comp9321.assign2.notifications.AuctionEndedNotSoldEmailToWinner;
import edu.unsw.comp9321.assign2.notifications.AuctionEndedToWinnerEmail;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AJAXAcceptAuctionOffer extends AbstractAction {

	@Override
	public String processSubmit() throws ServletException, IOException {
		Long id = Helper.toLong(param("id"));
		Integer accept = Helper.toInt(param("accept"));
		
		AuctionService service = DBUtil.getAuctionService();
		Auction auction = service.findById(id);
		
		if(accept == 1){
			// Accept
			auction.setAuctionStatus(AuctionStatus.ENDEDSOLD);
			// Send email to winning user
			
			AuctionEndedToWinnerEmail winnerEmail = new AuctionEndedToWinnerEmail(auction.getWinningUser(), auction);
			winnerEmail.send();
		}else{
			// Reject
			auction.setAuctionStatus(AuctionStatus.ENDEDNOTSOLD);
			
			// Send email to winning user
			AuctionEndedNotSoldEmailToWinner endedNotSold = new AuctionEndedNotSoldEmailToWinner(auction.getWinningUser(), auction);
			endedNotSold.send();
		}
		
		service.merge(auction);
		
		return "";
	}
}