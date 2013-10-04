package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;

public class IndexPage extends AbstractPage {
	
	@Override
	public String processView() throws ServletException, IOException{
		
		this.request.setAttribute("categories", DBUtil.getCategoryService().findAll());
		return "site/index.jsp";
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
}
