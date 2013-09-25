package edu.unsw.comp9321.assign2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
    Category category;
	
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
	
	@Column(name="bidincrement")
	int bidIncrement;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="expdate")
	Date expDate;//min: The minimum closing time is 3 min and the maximum is 60 min //  optional.

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostageDetails() {
		return postageDetails;
	}

	public void setPostageDetails(String postageDetails) {
		this.postageDetails = postageDetails;
	}

	public String getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(String reservePrice) {
		this.reservePrice = reservePrice;
	}

	public String getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(String startPrice) {
		this.startPrice = startPrice;
	}

	public int getBidIncrement() {
		return bidIncrement;
	}

	public void setBidIncrement(int bidIncrement) {
		this.bidIncrement = bidIncrement;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	// Helper Methods
	
	public String getShortDescription(){
		if(this.description.length() > 100){
			return this.description.substring(0,96) + " ...";
		}
		return this.description;
	}
	
}
