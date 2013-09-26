package edu.unsw.comp9321.assign2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.unsw.comp9321.assign2.dao.AuctionDAO;
import edu.unsw.comp9321.assign2.dao.UserDAO;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;


@Repository
@Transactional
public class BiddingServiceImpl implements BiddingService  {

	private UserDAO userDao;
	
	private AuctionDAO auctionDao;
	
	@Autowired
	public void setUserDao(UserDAO dao) {
		this.userDao = dao;
	}
	
	@Autowired
	public void setAuctionDao(AuctionDAO dao) {
		this.auctionDao = dao;
	}
	
	public boolean placeBid(Long userId, Long auctionId, Double bid){
		User user = userDao.find(userId);
		Auction auction = auctionDao.find(auctionId);
		
		auction.setCurrentPrice(auction.getCurrentPrice()+bid);
		auction.setWinningUser(user);
		
		return true;
	}
	
}
