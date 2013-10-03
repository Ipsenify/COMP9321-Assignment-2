package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.service.UserService;

public class UserNameValidator extends AbstractAction {

	@Override 
	public String processSubmit() throws ServletException, IOException{
		
		String username = request.getParameter("username");
		if(!username.isEmpty()){
			String output;
			if(usernameExists(username)){
				output = "{ \"result\": \"true\" }";
			}else{
				output = "{ \"result\": \"false\" }";
			}
			
			byte[] bytes = output.getBytes();
		    response.setContentType("application/json");
		    response.setContentLength(bytes.length);
		    
		    OutputStream out = response.getOutputStream();
			out.write(bytes, 0, bytes.length);
		}
		return "";
	}
	
	private boolean usernameExists(String username){
		UserService service = DBUtil.getUserService();
		boolean exists = service.findByUserName(username) != null;
		return exists;
	}
	
	@Override
	public boolean isPublic(){
		return true;
	}
}
