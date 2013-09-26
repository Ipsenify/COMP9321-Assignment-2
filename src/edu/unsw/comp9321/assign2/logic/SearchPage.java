package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;

public class SearchPage extends AbstractPage {

	@Override
	public String processView() throws ServletException, IOException {
		String query = param("q");
		Integer page = Helper.toInt(param("page"));
		SearchResult searchResult = new SearchResult(query, page);

		if (query != null && !query.isEmpty()) {
			AuctionService service = DBUtil.getAuctionService();
			searchResult.setResultSet(service.search(query));
		}
		request.setAttribute("searchResult", searchResult);
		return "auction/search.jsp";
	}

	@Override
	public boolean isPublic() {
		return true;
	}

	public class SearchResult {

		private List<Auction> resultSet;
		private String query;
		private int page;

		private static final int size = 10;

		public SearchResult(String query, Integer page) {
			this.query = query;
			this.page = page;
		}

		public List<Auction> getResultSet() {
			int start = page * size;
			int end = Math.min(this.resultSet.size(), start + size);
			return this.resultSet.subList(start, end);
		}
		
		public void setResultSet(List<Auction> resultSet){
			this.resultSet = resultSet;
		}

		public Integer getPage() {
			return this.page;
		}

		public String getQuery() {
			return this.query;
		}

		public boolean hasNext() {
			return this.resultSet != null && this.resultSet.size() > size
					&& this.resultSet.size() > (page + 1) * size;
		}

		public boolean hasPrevious() {
			return this.resultSet != null && this.resultSet.size() > size && page > 0;
		}
		
		public boolean isEmpty(){
			return this.resultSet == null || this.resultSet.isEmpty();
		}
	}
}
