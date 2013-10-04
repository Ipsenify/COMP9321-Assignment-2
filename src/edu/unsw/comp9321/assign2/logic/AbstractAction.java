package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.comp9321.assign2.common.SessionContext;

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
	
	public void preView() throws ServletException, IOException { }
	
	public void postView() throws ServletException, IOException { }
	
	public String executePOST() throws ServletException, IOException {
		preAction();
		preSubmit();
		String ret = processSubmit();
		postSubmit();
		postAction();
		return ret;
	}
	
	public void preSubmit() throws ServletException, IOException { }
	
	public void postSubmit() throws ServletException, IOException { }
	
	public void preAction() throws ServletException, IOException  { }
	
	public void postAction() throws ServletException, IOException { }
	
	public String processView() throws ServletException, IOException{
		throw new ServletException("GET method is not supported for " + request.getRequestURI() + ".");
	}
	
	public String processSubmit() throws ServletException, IOException{
		throw new ServletException("POST method is not supported for " + request.getRequestURI() + ".");
	}
	
	protected void include(String view) throws ServletException, IOException{
		request.getRequestDispatcher("WEB-INF/view/" + view).include(request, response);
	}
	
	public boolean isPublic(){
		return false;
	}
	
	public String param(String param){
		return (exists(param)) ? request.getParameter(param) : null;
	}
	
	public boolean exists(String param){
		return request.getParameterMap().containsKey(param);
	}
}
