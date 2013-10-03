package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;


public class ViewAuctionPage extends AbstractForm {
	
	@Override
	public String processView() throws ServletException, IOException{
		// Look up Auction by ID
		Integer id = Helper.toInt(param("id"));
		
		if(id != 0){
			AuctionService service = DBUtil.getAuctionService();
			Auction auction = service.findById((long)id);
			
			if(auction == null){
				//TODO: if doesn't exists, go to error page
					
			}
			
			request.setAttribute("auction", auction);
			return "auction/view.jsp";
		}
		throw new ServletException("");
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
}
