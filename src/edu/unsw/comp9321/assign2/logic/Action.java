package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.comp9321.assign2.common.SessionContext;

public interface Action {
	
	void setServlet(HttpServletRequest request, HttpServletResponse response);
	void setContext(SessionContext context);
	
	String executeGET() throws ServletException, IOException;
	String executePOST() throws ServletException, IOException;
	
	boolean isPublic();
}
