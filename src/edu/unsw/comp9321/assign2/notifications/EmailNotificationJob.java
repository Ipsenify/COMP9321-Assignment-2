package edu.unsw.comp9321.assign2.notifications;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.Auction.AuctionStatus;
import edu.unsw.comp9321.assign2.service.AuctionService;

public class EmailNotificationJob implements Job {

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		AuctionService service = DBUtil.getAuctionService();
		List<Auction> auctions = service.findAllActive();
		for(Auction auction : auctions){
			if(!auction.isRunning()){
				// Auction has Expired
				if(auction.getWinningUser() == null){
					// Ended Not Sold
					auction.setAuctionStatus(AuctionStatus.ENDEDNOTSOLD);
					
					AuctionEndedNotSoldToOwnerEmail endedNotSold = new AuctionEndedNotSoldToOwnerEmail(auction.getAuthor(), auction);
					endedNotSold.send();
				}else if(auction.getCurrentPrice() >= auction.getReservePrice()){
					// Email both parties and change status to ended Sold
					auction.setAuctionStatus(AuctionStatus.ENDEDSOLD);
					AuctionEndedToOwnerEmail endedOwner = new AuctionEndedToOwnerEmail(auction.getAuthor(), auction);
					endedOwner.send();
					
					AuctionEndedToWinnerEmail endedWinner = new AuctionEndedToWinnerEmail(auction.getWinningUser(), auction);
					endedWinner.send();
				}else {
					// Email owner to check offer, status awaiting approval
					auction.setAuctionStatus(AuctionStatus.AWAITING);
					
					AuctionEndedActionRequiredToOwnerEmail actionRequired = new AuctionEndedActionRequiredToOwnerEmail(auction.getAuthor(), auction);
					actionRequired.send();
				}
				service.save(auction);
			}
		}
	}
}