package edu.unsw.comp9321.assign2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

import edu.unsw.comp9321.assign2.dao.UserDAO;
import edu.unsw.comp9321.assign2.model.User;

@Repository
@Transactional
public class UserServiceImpl implements UserService {
	
	UserDAO dao;
    
    @Autowired
    public void setDao(UserDAO dao) {
            this.dao = dao;
    }
    
    public void persist(User user) {
            dao.persist(user);
    }
    
    public void merge(User user){
    		dao.merge(user);
    }
    
    public List<User> findAll() {
            return dao.findAll();
    }
    
    public User findById(Long id){
    	return dao.find(id);
    }
    
    public User findByUserName(String username){
    	Search search = new Search(User.class);
		search.addFilterEqual("userName", username);
		return dao.searchUnique(search);
    }

	public User findByCredentials(String username, String password){
		Search search = new Search(User.class);
		search.addFilterEqual("userName", username);
		search.addFilterEqual("password", password);
		return dao.searchUnique(search);
		
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
    
    public User findByConformation(String confirmationurl){
    	Search search = new Search(User.class);
		search.addFilterEqual("confirmationUrl", confirmationurl);
		return dao.searchUnique(search);
    }
}
