package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.Auction.AuctionStatus;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;


public class ViewAuctionPage extends AbstractForm {
	
	@Override
	public String processView() throws ServletException, IOException{
		// Look up Auction by ID
		if(!exists("id")){
			throw new ServletException("The Auction requested does not exist");
		}
		Integer id = Helper.toInt(param("id"));
		
		if(id != 0){
			AuctionService service = DBUtil.getAuctionService();
			Auction auction = service.findById((long)id);
			
			if(auction == null){
				throw new ServletException("The Auction requested does not exist");
			}
			
			if(context.getRedirectError() != null && !context.getRedirectError().isEmpty()){
				setError(context.getRedirectError());
				context.setRedirectError(null);
			}
			if(context.getRedirectSuccess() != null && !context.getRedirectSuccess().isEmpty()){
				setSuccess(context.getRedirectSuccess());
				context.setRedirectSuccess(null);
			}
			
			// Set Status
			if(auction.getStatus() != AuctionStatus.ACTIVE.getValue()){
				setWarning("This auction is not currently running");
			}
			request.setAttribute("auction", auction);
			
			return "auction/view.jsp";
		}
		throw new ServletException("The Auction requested does not exist");
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
}
