package edu.unsw.comp9321.assign2.service;

import java.util.List;

import edu.unsw.comp9321.assign2.model.Category;

public interface CategoryService {

	public List<Category> findAll();

	public Category findById(Long id);

}
