package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;


public class ViewAuctionPage extends AbstractPage {
	
	@Override
	public String processView() throws ServletException, IOException{
		
		// Look up Auction by ID
		
		return "auction/view.jsp";
	}
}
