package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;

public class AdminPanelPage extends AbstractPage {
	
	@Override
	public String processView() throws ServletException, IOException{
		
		return "site/index.jsp";
	}
}
