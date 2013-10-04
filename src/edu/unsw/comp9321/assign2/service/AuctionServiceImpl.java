package edu.unsw.comp9321.assign2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

import edu.unsw.comp9321.assign2.dao.AuctionDAO;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.model.User;

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

	public Auction save(Auction auction) {
		return dao.save(auction);
	}

	public void merge(Auction auction) {
		dao.merge(auction);
	}

	public void remove(Auction auction) {
		dao.remove(auction);
	}

	public List<Auction> findAll() {
		return dao.findAll();
	}

	public Auction findById(Long id) {
		return dao.find(id);
	}
	
    public List<Auction> search(String query, String category){
    	Search search = new Search();
		
		Filter filter;
		if(category == null || category.isEmpty()){
			// If Category is empty, don't search on category
			filter = Filter.and(Filter.like( "title","%" + query + "%"));
		}else{
			filter = Filter.and(Filter.equal("category.id",category), Filter.like("title","%" + query + "%"));
		}
		search.addFilter(filter);
		return dao.search(search);
    }

	public List<Auction> searchActive(String query, String category) {
		Search search = new Search();
		
		Filter filter;
		if(category == null || category.isEmpty()){
			// If Category is empty, don't search on category
			filter = Filter.and(Filter.equal("status", 1), Filter.like( "title","%" + query + "%"));
		}else{
			filter = Filter.and(Filter.equal("status", 1), Filter.equal("category.id",category), Filter.like("title","%" + query + "%"));
		}
		search.addFilter(filter);
		// Auction should be running
		
		
		//search.addFilterOr(Filter.ilike("category.name","%" + query + "%"));
		// Search by Category
		//search.addFilterOr(Filter.ilike("title","%" + query + "%"));
		// Search by Description
		//search.addFilterOr(Filter.ilike("description","%" + query + "%"));
		
		return dao.search(search);
	}
	
	

    public List<Auction> findAllArchivedByAuthor(User user){
    	// All other Statuses
    	Search search = new Search();
    	
    	Filter filter = Filter.and(Filter.equal("author", user), Filter.notIn("status", 1, 2));
		search.addFilter(filter);
		
    	return dao.search(search);
    }
    
    public List<Auction> findAllActiveByAuthor(User user){
    	// Status = 2 or 3
    	Search search = new Search();
    	
    	Filter filter = Filter.and(Filter.equal("author", user), Filter.in("status", 1, 2));
		search.addFilter(filter);
		
    	return dao.search(search);
    }

    public List<Auction> findAllActive(){
    	Search search = new Search();
    	
    	Filter filter = Filter.and(Filter.equal("status", 1));
		search.addFilter(filter);
    	
    	return dao.search(search);
    }
}
