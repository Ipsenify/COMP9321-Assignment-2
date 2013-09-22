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
		map.put("login", LoginForm.class);
		map.put("register", RegistrationForm.class);
		map.put("home", IndexPage.class);
	}
	
	public Action getAction(String actionStr){
		if(map.containsKey(actionStr)){
			try {
				Class<?> cls = map.get(actionStr);
				return (Action) Class.forName(cls.getName()).newInstance();
			} catch (Exception e) {
				return new ErrorPage(actionStr);
			}
		}else if(actionStr == null){
			// Go to Default
			return new IndexPage();
		}else{
			return new ErrorPage(actionStr);
		}
	}
}
