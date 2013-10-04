package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.service.AuctionService;

public class ViewMyAuctionsPage extends AbstractPage {
	
	@Override 
	public String processView() throws ServletException, IOException
	{
		AuctionService service = DBUtil.getAuctionService();
		List<Auction> archived = service.findAllArchivedByAuthor(context.getUser());
		List<Auction> active = service.findAllActiveByAuthor(context.getUser());
		
		request.setAttribute("archived", archived);
		request.setAttribute("active", active);
		
		return "auction/list.jsp";
	}
}
