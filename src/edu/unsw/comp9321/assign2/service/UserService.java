package edu.unsw.comp9321.assign2.service;

import java.util.List;

import edu.unsw.comp9321.assign2.model.User;

public interface UserService {

	public void persist(User user);

	public void merge(User user);

    public List<User> findAll();

    public User findById(Long id);
    
    public User findByName(String name);

}
