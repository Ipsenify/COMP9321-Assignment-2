package edu.unsw.comp9321.assign2.logic.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.logic.SearchResult;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AdminUsersPage extends AdminPage {

	@Override
	public String processView() throws ServletException, IOException {

		String query = param("q");

		Integer page = Helper.toInt(param("page"));
		SearchResult<User> searchResult = new SearchResult<User>(query, "", page);
		
		if ((query != null && !query.isEmpty())) {
			UserService service = DBUtil.getUserService();
			searchResult.setResultSet(service.searchByUsername(query));

		} else {

			List<User> users = DBUtil.getUserService().findAll();
			searchResult.setResultSet(users);
		}

		request.setAttribute("results", searchResult);
		return "admin/users/index.jsp";
	}

}
