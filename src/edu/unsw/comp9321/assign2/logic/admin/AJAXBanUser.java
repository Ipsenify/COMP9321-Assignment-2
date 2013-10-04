package edu.unsw.comp9321.assign2.logic.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.Auction.AuctionStatus;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.model.User.UserStatus;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AJAXBanUser extends AdminAction {

	@Override
	public String processSubmit() throws ServletException, IOException {
		Long id = Helper.toLong(param("id"));

		UserService service = DBUtil.getUserService();
		User user = service.findById(id);

		// Change Status
		user.setUserStatus(UserStatus.BANNED);
		service.merge(user);
		
		// Halt all user active auctions (1/2)
		AuctionService auctionService = DBUtil.getAuctionService();
		List<Auction> active = auctionService.findAllActiveByAuthor(user);
		for(Auction auction : active){
			auction.setAuctionStatus(AuctionStatus.SUSPENDED);
			auctionService.merge(auction);
		}
		return "";
	}
}