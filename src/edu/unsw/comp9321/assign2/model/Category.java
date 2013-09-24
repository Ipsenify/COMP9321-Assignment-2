package edu.unsw.comp9321.assign2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid", updatable = false)
	Long id;
	
	@Column(name="name")
	String name;
	
}
