package edu.unsw.comp9321.assign2.common;

import java.util.Date;

import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.model.User.UserStatus;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class SessionContext {

	private Date expiry_date;
	
	private User currentUser;
	
	public SessionContext(Date expiry_date){
		this.expiry_date = expiry_date;
	}
	
	public boolean login(String username, String crypt){
		UserService service = DBUtil.getUserService();
		this.currentUser = service.findByCredentials(username, crypt);
		if(this.currentUser != null){
			// Check status
			// Status: 1 = SUCCESS
			// Status: 0 = NOT VERIFIED
			// Status: -1 = DENIED ACCESS
			if(this.currentUser.getStatus() == UserStatus.VERIFIED.getValue()){
				// You're in
				this.currentUser.onLogin();
				service.merge(this.currentUser);
				return true;
			}
		}
		return false;
	}
	
	public User reloadUser(){
		UserService service = DBUtil.getUserService();
		this.currentUser = service.findById(this.getUserId());
		return this.currentUser;
	}
	
	public void logout(){
		this.currentUser = null;
	}
	
	public Long getUserId(){
		if(this.currentUser != null) return this.currentUser.getId();
		return null;
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
	
	private String redirectError;
	
	public void setRedirectError(String error){
		this.redirectError = error;
	}
	
	public String getRedirectError(){
		return this.redirectError;
	}
	
	private String redirectSuccess;
	
	public void setRedirectSuccess(String success){
		this.redirectSuccess = success;
	}
	
	public String getRedirectSuccess(){
		return this.redirectSuccess;
	}
	
	private String token = Helper.generateNext();
	
	public void refreshToken(){
		token = Helper.generateNext();
	}
	
	public String getSyncronizerToken(){
		return this.token;
	}
}
