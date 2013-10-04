package edu.unsw.comp9321.assign2.logic.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.logic.SearchResult;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AdminAuctionsPage extends AdminPage {

	@Override
	public String processView() throws ServletException, IOException
	{
		// If a search has been performed display the results
		String query = param("q");
		String category = param("c");
		
		Integer page = Helper.toInt(param("page"));
		SearchResult<Auction> searchResult = new SearchResult<Auction>(query, category, page);

		if ((query != null && !query.isEmpty()) || (category != null && !category.isEmpty())) {
			AuctionService service = DBUtil.getAuctionService();
			searchResult.setResultSet(service.search(query, category));

		}else{
			List<Auction> auctions = DBUtil.getAuctionService().findAll();
			searchResult.setResultSet(auctions);
		}

		request.setAttribute("results", searchResult);		
		request.setAttribute("categories", DBUtil.getCategoryService().findAll());
		return "admin/auctions/index.jsp";
	}
	
}
