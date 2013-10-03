package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.Part;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.Category;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;

public class UpdateAuctionForm extends AbstractForm {
	
	@Override
	public String processView() throws ServletException, IOException
	{
		Auction auction = DBUtil.getAuctionService().findById(Helper.toLong(param("id")));
		if(auction == null){
			throw new ServletException("The requested auction does not exist");
		}
		if(auction.getAuthor().getId() != context.getUserId()){
			throw new ServletException("You do not have access to edit this auction.");
		}
		request.setAttribute("auction", auction);
		return "auction/update.jsp";
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException
	{
		AuctionService service = DBUtil.getAuctionService();
		Auction auction = service.findById(Helper.toLong(param("id")));
		
		auction.setTitle(param("title"));

		// Look up category
		Category category = DBUtil.getCategoryService().findById(
				(long) Helper.toInt(param("category")));
		auction.setCategory(category);

		// Upload file
		Part filePart = request.getPart("image");
		InputStream filecontent = filePart.getInputStream();

		byte[] bFile = new byte[(int) filePart.getSize()];

		try {
			// convert file into array of bytes
			filecontent.read(bFile);
			filecontent.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		auction.setPicture(bFile);
		
		auction.setDescription(param("description"));
		auction.setPostageDetails(param("postagedetails"));
		auction.setReservePrice(Helper.toDouble(param("reservePrice")));
		auction.setCurrentPrice(Helper.toDouble(param("startPrice")));
		auction.setBidIncrement(Helper.toDouble(param("increment")));

		Integer auctionLength = Helper.toInt(param("exptime"));

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, auctionLength);
		auction.setExpDate(cal.getTime());

		// Insert to database
		try {
			service.merge(auction);
			
			return "redirect:auction/view?id=" + auction.getId();
		} catch (Exception e) {
			throw new ServletException(
					"The input you have enterered is corrupted.");
		}
	}
}
