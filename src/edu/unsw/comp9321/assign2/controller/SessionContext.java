package edu.unsw.comp9321.assign2.controller;

import java.util.Date;

import edu.unsw.comp9321.assign2.dao.UserDAOImpl;
import edu.unsw.comp9321.assign2.model.User;

public class SessionContext {

	private Date expiry_date;
	
	private User currentUser;
	
	public SessionContext(Date expiry_date){
		this.expiry_date = expiry_date;
	}
	
	public boolean login(String username, String crypt){
		/*UserDAOImpl dao = DAOFactory.getInstance().getUserDAO();
		this.currentUser = dao.findByCredentials(username, crypt);
		if(this.currentUser != null){
			this.currentUser.onLogin();
			
			dao.persist(this.currentUser);
			dao.flush();
			return true;
		}*/
		return false;
	}
	
	public void logout(){
		this.currentUser = null;
	}
	
	public User getUser(){
		return currentUser;
	}
	
	public boolean isAuthenticated(){
		return currentUser != null;
	}
	
	public boolean isValid(){
		return expiry_date.before(new Date());
	}
}
