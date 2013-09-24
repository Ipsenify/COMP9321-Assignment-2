package edu.unsw.comp9321.assign2.service;

import java.util.List;

import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

public interface AuctionService {

	public void persist(Auction user);

	public void merge(Auction user);

    public List<Auction> findAll();

    public Auction findById(Long id);

}
