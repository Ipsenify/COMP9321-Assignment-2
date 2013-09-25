package edu.unsw.comp9321.assign2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

import edu.unsw.comp9321.assign2.dao.AuctionDAO;
import edu.unsw.comp9321.assign2.model.Auction;

@Repository
@Transactional
public class AuctionServiceImpl implements AuctionService {

	AuctionDAO dao;

	@Autowired
	public void setDao(AuctionDAO dao) {
		this.dao = dao;
	}

	public void persist(Auction auction) {
		dao.persist(auction);
	}

	public void merge(Auction auction) {
		dao.merge(auction);
	}

	public List<Auction> findAll() {
		return dao.findAll();
	}

	public Auction findById(Long id) {
		return dao.find(id);
	}

	public List<Auction> search(String query) {
		Search search = new Search();
		// Search by Title
		search.addFilterILike("title", "%"+query+"%");
		// Search by Description
		
		return dao.search(search);
	}

}
