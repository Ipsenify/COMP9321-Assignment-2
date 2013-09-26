package edu.unsw.comp9321.assign2.model;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "auctions")
public class Auction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auctionid", updatable = false)
	Long id;

	@ManyToOne
	User author;

	@Column(name = "title")
	String title; // 10 words max

	@ManyToOne
	Category category;

	@Column(name = "picture")
	String picture;

	@Column(name = "description")
	String description; // 100 words max

	@Column(name = "postagedetails")
	String postageDetails;

	@Column(name = "reserveprice")
	Double reservePrice; // The reserve price is confidential and should be
							// visible only to the user.

	@Column(name = "currentprice")
	Double currentPrice;

	@Column(name = "bidincrement")
	int bidIncrement;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expdate")
	Date expDate;// min: The minimum closing time is 3 min and the maximum is 60
					// min // optional.

	@ManyToOne
	User winningUser;

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

	public Double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(Double reservePrice) {
		this.reservePrice = reservePrice;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
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

	public User getWinningUser() {
		return this.winningUser;
	}

	public void setWinningUser(User winningUser) {
		this.winningUser = winningUser;
	}

	public User getAuthor() {
		return this.author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	// Helper Methods

	public String getShortDescription() {
		if (this.description.length() > 100) {
			return this.description.substring(0, 96) + " ...";
		}
		return this.description;
	}

	public boolean isRunning() {
		return new Date().before(expDate);
	}

}
