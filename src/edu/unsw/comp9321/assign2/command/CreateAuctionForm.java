package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.model.User;

public class CreateAuctionForm extends AbstractForm {

	@Override
	public String processView() throws ServletException, IOException {
		
		return "auction/_form.jsp";
	}
	
	@Override
	public String processSubmit() throws ServletException, IOException {
		
		return "";
	}
}
