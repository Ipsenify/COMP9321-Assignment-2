package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.notifications.BidEmail;
import edu.unsw.comp9321.assign2.notifications.OutBidEmail;
import edu.unsw.comp9321.assign2.service.BiddingService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AuctionBidForm extends AbstractSynchronizedForm {

	
	@Override
	public String processSubmit() throws ServletException, IOException
	{
		Long auctionid = Helper.toLong(param("bid.auctionid"));
		Long userid = context.getUserId();
		
		if(auctionid != 0){
			User currentWinner = DBUtil.getAuctionService().findById(auctionid).getWinningUser();
			DBUtil.close();
			
			BiddingService service = DBUtil.getBiddingService();
			Double bid = Helper.toDouble(param("bid.price"));
			
			if(!service.placeBid(userid, auctionid, bid)){
				context.setRedirectError("An error has occured, bid was not placed.");
			}else{
				context.setRedirectSuccess("Your bid has been placed.");
				// Send outbid email to current winner
				if(currentWinner != null){
					OutBidEmail outBidEmail = new OutBidEmail(currentWinner);
					outBidEmail.send();
				}
				// Send Email to Winning User
				BidEmail bidEmail = new BidEmail(context.getUser());
				bidEmail.send();
			}
		}
		return "redirect:auction/view?id="+auctionid;
	}
}
