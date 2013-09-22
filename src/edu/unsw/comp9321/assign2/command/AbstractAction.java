package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.comp9321.assign2.controller.SessionContext;

public abstract class AbstractAction implements Action{

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	protected SessionContext context;
	
	public void setServlet(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void setContext(SessionContext context){
		this.context = context;
	}
	
	public String executeGET() throws ServletException, IOException{
		preAction();
		preView();
		String ret = processView();
		postView();
		postAction();
		return ret;
	}
	
	public void preView() { }
	
	public void postView(){ }
	
	public String executePOST() throws ServletException, IOException {
		preAction();
		preSubmit();
		String ret = processSubmit();
		postSubmit();
		postAction();
		return ret;
	}
	
	public void preSubmit() { }
	
	public void postSubmit() { }
	
	public void preAction() { }
	
	public void postAction() { }
	
	public String processView() throws ServletException, IOException{
		throw new ServletException("GET method is not supported.");
	}
	
	public String processSubmit() throws ServletException, IOException{
		throw new ServletException("POST method is not supported.");
	}
	
	protected void include(String view) throws ServletException, IOException{
		request.getRequestDispatcher("WEB-INF/view/" + view).include(request, response);
	}
}
