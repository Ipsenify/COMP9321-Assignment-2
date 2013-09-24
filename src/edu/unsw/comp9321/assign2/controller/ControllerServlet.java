package edu.unsw.comp9321.assign2.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.comp9321.assign2.command.Action;
import edu.unsw.comp9321.assign2.command.ActionFactory;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(name = "ControllerServlet", urlPatterns = { "/" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String LOGIN_PAGE = "login";
	
	private HashMap<String, SessionContext> contexts;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // Create the context set
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
		
		String actionStr = request.getRequestURI().substring(request.getContextPath().length());
		Action action = ActionFactory.getInstance().getAction(actionStr);
		if(action == null){
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Response Not Found");
			return;
		}
		action.setServlet(request, response);
		action.setContext(context);
		if(!action.isPublic() && !context.isAuthenticated()){
			// Redirect to login page
			response.sendRedirect(request.getContextPath() + "/" + LOGIN_PAGE + "?redirectUrl=" + actionStr);
			DBUtil.close();
			return;
		}
		
		String view = action.executeGET();
		if(!view.isEmpty()){
			if(view.startsWith("redirect:")){
				response.sendRedirect(request.getContextPath() + "/" + view.substring(9));
			}else if(view.startsWith("include:")){
				request.getRequestDispatcher("/" + view.substring(8)).forward(request, response);
			}else{
				request.getRequestDispatcher("/WEB-INF/view/" + view).forward(request, response);
			}
		}
		DBUtil.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionContext context = getSessionContext(request.getSession().getId());
		request.setAttribute("context", context);
		
		String actionStr = request.getRequestURI().substring(request.getContextPath().length());
		Action action = ActionFactory.getInstance().getAction(actionStr);
		if(action == null){
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Response Not Found");
			return;
		}
		action.setServlet(request, response);
		action.setContext(context);
		if(!action.isPublic() && !context.isAuthenticated()){
			// Redirect to login page
			response.sendRedirect(request.getContextPath() + "/" + LOGIN_PAGE + "?redirectUrl=" + actionStr);
			DBUtil.close();
			return;
		}
		
		String view = action.executePOST();
		if(!view.isEmpty()){
			if(view.startsWith("redirect:")){
				response.sendRedirect(request.getContextPath() + "/" + view.substring(9));
			}else if(view.startsWith("include:")){
				request.getRequestDispatcher("/" + view.substring(8)).forward(request, response);
			}else{
				request.getRequestDispatcher("/WEB-INF/view/" + view).forward(request, response);
			}
		}
		DBUtil.close();
	}

}
