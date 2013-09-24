package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.controller.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;


public class ViewAuctionPage extends AbstractPage {
	
	@Override
	public String processView() throws ServletException, IOException{
		// Look up Auction by ID
		Integer id = Helper.toInt(param("id"));
	
		
		AuctionService service = DBUtil.getAuctionService();
		Auction auction = service.findById((long)id);
		
		//TODO: if doesn't exists, go to error page
		
		request.setAttribute("auction", auction);
		return "auction/view.jsp";
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
}
