package edu.unsw.comp9321.assign2.command;

import java.util.HashMap;

public class ActionFactory {

	private static final ActionFactory commandFactory = new ActionFactory();
	
	public static ActionFactory getInstance(){
		return commandFactory;
	}
	
	private HashMap<String, Class<?>> map;

	private ActionFactory(){
		map = new HashMap<String, Class<?>>();
		map.put("/", IndexPage.class);
		map.put("/index", IndexPage.class);
		map.put("/home", IndexPage.class);
		map.put("/login", LoginForm.class);
		map.put("/register", RegistrationForm.class);
		map.put("/admin/", AdminPanelPage.class);
		map.put("/auction/create", CreateAuctionForm.class);
		map.put("/auction/view", ViewAuctionPage.class);
	}
	
	public Action getAction(String actionStr){
		if(map.containsKey(actionStr)){
			try {
				Class<?> cls = map.get(actionStr);
				return (Action) Class.forName(cls.getName()).newInstance();
			} catch (Exception e) {
				return new ErrorPage(actionStr);
			}
		}else{
			return new ErrorPage(actionStr);
		}
	}
}
