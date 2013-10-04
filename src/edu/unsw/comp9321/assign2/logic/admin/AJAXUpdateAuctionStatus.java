package edu.unsw.comp9321.assign2.logic.admin;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AJAXUpdateAuctionStatus extends AdminAction {
	
	@Override
	public String processSubmit() throws ServletException, IOException
	{
		Long id = Helper.toLong(param("id"));
		Integer status = Helper.toInt(param("status"));
		
		AuctionService service = DBUtil.getAuctionService();
		Auction auction = service.findById(id);
		auction.setStatus(status);
		service.merge(auction);
		
		return "";
	}
}
