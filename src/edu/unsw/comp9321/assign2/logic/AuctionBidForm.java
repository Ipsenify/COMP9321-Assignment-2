package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.service.BiddingService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AuctionBidForm extends AbstractForm {

	
	@Override
	public String processSubmit() throws ServletException, IOException
	{
		Long auctionid = (long) Helper.toInt(param("bid.auctionid"));
		Long userid = context.getUserId();
		
		if(auctionid != 0){
			BiddingService service = DBUtil.getBiddingService();
			if(!service.placeBid(userid, auctionid, 10.00)){
				setError("ERROR...");
			}
		}
		return "redirect:auction/view?id="+auctionid;
	}
}
