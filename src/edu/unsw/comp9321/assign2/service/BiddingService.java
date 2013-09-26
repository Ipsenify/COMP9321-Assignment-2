package edu.unsw.comp9321.assign2.service;

public interface BiddingService {
	
	public boolean placeBid(Long userId, Long auctionId, Double bid);
	
}
