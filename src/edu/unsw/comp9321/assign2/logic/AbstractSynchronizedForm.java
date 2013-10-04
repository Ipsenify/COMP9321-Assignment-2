package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

public class AbstractSynchronizedForm extends AbstractForm {
	
	@Override
	public void postAction(){
		super.postAction();
		request.setAttribute("synchronizer", context.getSyncronizerToken());
	}
	
	@Override 
	public void preSubmit() throws ServletException, IOException { 
		super.preSubmit();
		// Check Synchronizer Token
		String syncronizer = param("synchronizer");
		if(!context.getSyncronizerToken().equals(syncronizer)){
			throw new ServletException("Synchronizer Token Invalid");
		}
		context.refreshToken();
	}
	
}
