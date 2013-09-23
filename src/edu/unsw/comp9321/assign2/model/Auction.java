package edu.unsw.comp9321.assign2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="auctions")
public class Auction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auctionid", updatable = false)
	Long id;
	
	@Column(name="title")
	String title; // 10 words max 
	
	@Column(name="category")
	String category;
	
	@Column(name="picture")
	String picture;
	
	@Column(name="description")
	String description; // 100 words max
	
	@Column(name="postagedetails")
	String postageDetails;
	
	@Column(name="reserveprice")
	String reservePrice; //The reserve price is confidential and should be visible only to the user. 
	
	@Column(name="startingprice")
	String startPrice;
	
	@Column(name="bidIncrement")
	int bidIncrement;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="expdate")
	Date expDate;//min: The minimum closing time is 3 min and the maximum is 60 min //  optional.
	
	
}
