package edu.unsw.comp9321.assign2.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.unsw.comp9321.assign2.dao.UserDAO;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.service.UserService;

public class DBUtil {

	private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	public static UserService getUserService() {
		ctx.refresh();
		return (UserService) ctx.getBean("userService");
	}

	public static UserDAO getUserDAO() {
		ctx.refresh();
		return (UserDAO) ctx.getBean("userDAO");
	}

	public static AuctionService getAuctionService() {
		ctx.refresh();
		return (AuctionService) ctx.getBean("auctionService");
	}

	public static void close() {
		ctx.close();
	}
}
