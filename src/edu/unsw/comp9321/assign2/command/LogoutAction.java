package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;

public class LogoutAction extends AbstractAction {

	@Override
	public String processView() throws ServletException, IOException{
		this.context.logout();
		return "redirect:home";
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
}
