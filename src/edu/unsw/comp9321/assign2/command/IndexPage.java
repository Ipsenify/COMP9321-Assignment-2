package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;

public class IndexPage extends AbstractPage {
	
	@Override
	public String processView() throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		//User user =  (User) session.get(User.class, 1);
		
		//DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);  
	    //UserDAO userDAO = factory.getUserDAO();
	    //User user = userDAO.findById((long)1, false);
	    
		UserService userService = DBUtil.getUserService();
		User user = userService.findById((long)1);
		
		this.request.setAttribute("user", user);
		
		return "site/index.jsp";
	}
}
