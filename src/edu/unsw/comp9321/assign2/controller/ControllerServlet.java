package edu.unsw.comp9321.assign2.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.unsw.comp9321.assign2.command.Action;
import edu.unsw.comp9321.assign2.command.ActionFactory;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(name = "ControllerServlet", urlPatterns = { "/" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, SessionContext> contexts;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        contexts = new HashMap<String, SessionContext>();
    }

    private SessionContext getSessionContext(String sessionId) {
		if (contexts.containsKey(sessionId)) {
			// Check expiry
			SessionContext bean = contexts.get(sessionId);
			if(bean.isValid()){
				return bean;
			}
			contexts.remove(bean);
		}
		SessionContext bean = new SessionContext(new Date(new Date().getTime() + 1800)); // Expire in 30 minutes
		contexts.put(sessionId, bean);
		return bean;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionContext context = getSessionContext(request.getSession().getId());
		request.setAttribute("context", context);
		
		String actionStr = request.getParameter("action");
		Action action = ActionFactory.getInstance().getAction(actionStr);
		action.setServlet(request, response);
		action.setContext(context);
		
		String view = action.executeGET();
		
		request.getRequestDispatcher("WEB-INF/view/" + view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionContext context = getSessionContext(request.getSession().getId());
		request.setAttribute("context", context);
		
		String actionStr = request.getParameter("action");
		Action action = ActionFactory.getInstance().getAction(actionStr);
		action.setServlet(request, response);
		action.setContext(context);
		
		String view = action.executePOST();
		
		request.getRequestDispatcher("WEB-INF/view/" + view).forward(request, response);
	}

}
