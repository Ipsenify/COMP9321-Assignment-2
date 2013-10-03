package edu.unsw.comp9321.assign2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.unsw.comp9321.assign2.dao.CategoryDAO;
import edu.unsw.comp9321.assign2.model.Category;

@Repository
@Transactional
public class CategoryServiceImpl implements CategoryService {

	CategoryDAO dao;

	@Autowired
	public void setDao(CategoryDAO dao) {
		this.dao = dao;
	}

	public List<Category> findAll() {
		return dao.findAll();
	}

	public Category findById(Long id) {
		return dao.find(id);
	}

}
