package edu.unsw.comp9321.assign2.logic.admin;

import java.io.IOException;

import javax.servlet.ServletException;

public class AdminPanelPage extends AdminPage {
	
	@Override
	public String processView() throws ServletException, IOException{
		
		return "admin/index.jsp";
	}
}
