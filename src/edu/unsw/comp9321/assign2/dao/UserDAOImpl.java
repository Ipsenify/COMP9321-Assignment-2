package edu.unsw.comp9321.assign2.dao;

import com.googlecode.genericdao.search.Search;

import edu.unsw.comp9321.assign2.model.User;

public class UserDAOImpl extends BaseDAO<User, Long> implements UserDAO{
	
	public User findByCredentials(String username, String password){
		
		Search search = new Search(User.class);
		search.addFilterEqual("userName", username);
		search.addFilterEqual("password", password);
		return this.searchUnique(search);
		
		/*
		 * 
		 * ISearch search = Util.getSearchFromParams(request.getParameterMap());
		 * 
		 * return Util.addSearchParamsToURL("redirect:list.do", request.getParameterMap(), true, true, true);
		 * 
		 * public Town findByName(String name) {
                return dao.searchUnique(new Search().addFilterEqual("name", name).addFetch("citizens"));
        }

		 */
	}
}