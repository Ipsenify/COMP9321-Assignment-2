package edu.unsw.comp9321.assign2.service;

import java.util.List;

import edu.unsw.comp9321.assign2.model.User;

public interface UserService {

	public void refresh(User user);
	
	public void persist(User user);
	
	public User save(User user);

	public void merge(User user);

    public List<User> findAll();

    public User findById(Long id);
    
    public User findByUserName(String username);
    
    public User findByCredentials(String name, String password);

    public User findByConformation(String confirmationurl);
    
    public User findByIdWithAuctions(Long id);
}
