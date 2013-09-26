package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;

public class ViewMyAuctionsPage extends AbstractPage {
	
	@Override 
	public String processView() throws ServletException, IOException
	{
		UserService service = DBUtil.getUserService();
		User user = service.findByIdWithAuctions(context.getUserId());
		
		Set<Auction> auctions = user.getAuctions();
		request.setAttribute("auctions", auctions);
		
		return "auction/list.jsp";
	}
}
