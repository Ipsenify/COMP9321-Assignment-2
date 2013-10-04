package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;

public class SearchPage extends AbstractPage {

	@Override
	public String processView() throws ServletException, IOException {
		String query = param("q");
		String category = param("c");
		
		Integer page = Helper.toInt(param("page"));
		SearchResult<Auction> searchResult = new SearchResult<Auction>(query, category, page);

		if ((query != null && !query.isEmpty()) || (category != null && !category.isEmpty())) {
			AuctionService service = DBUtil.getAuctionService();
			searchResult.setResultSet(service.searchActive(query, category));
		}
		request.setAttribute("searchResult", searchResult);
		return "auction/search.jsp";
	}

	@Override
	public boolean isPublic() {
		return true;
	}

	
}
