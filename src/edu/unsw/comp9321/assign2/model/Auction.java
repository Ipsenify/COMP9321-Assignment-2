package edu.unsw.comp9321.assign2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.unsw.comp9321.assign2.logic.ConfirmationService;
import edu.unsw.comp9321.assign2.model.User.UserStatus;

@Entity(name = "auctions")
public class Auction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auctionid", updatable = false)
	Long id;

	@ManyToOne
	User author;

	@Column(name = "title", length=60)
	String title; // 10 words max

	@ManyToOne
	Category category;

	@Column(name="picture", columnDefinition="mediumblob")
	byte[] picture;

	@Column(name = "description", length=600)
	String description; // 100 words max

	@Column(name = "postagedetails")
	String postageDetails;

	@Column(name = "reserveprice")
	Double reservePrice; // The reserve price is confidential and should be
							// visible only to the user.

	@Column(name = "currentprice")
	Double currentPrice;

	@Column(name = "bidincrement")
	Double bidIncrement;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expdate")
	Date expDate;// min: The minimum closing time is 3 min and the maximum is 60
					// min // optional.

	@ManyToOne
	User winningUser;
	
	@Column(name="status")
	int status;

	@PrePersist
	protected void onCreate() {
		this.status = AuctionStatus.ACTIVE.getValue();
	}
	
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

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
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

	public Double getBidIncrement() {
		return bidIncrement;
	}

	public void setBidIncrement(Double bidIncrement) {
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
	
	public int getStatus(){
		return this.status;
	}
	
	public void setStatus(int status){
		this.status = status;
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

	public Double getNextBid(){
		return this.currentPrice + this.bidIncrement;
	}
	
	public String getTimeLeft(){
		int diff = (int)((this.expDate.getTime()/60000) - (new Date().getTime()/60000));
		return Integer.toString(diff);
	}
	
	public enum AuctionStatus {
		SUSPENDED(0, "Suspended"), ACTIVE(1, "Active"), AWAITING(2,
				"Awaiting Approval"), ENDEDSOLD(3, "Ended - Sold"), ENDEDNOTSOLD(4, "Ended - Not Sold");
		private int status;
		private String str;
		private AuctionStatus(int status, String str) {
			this.status = status;
			this.str = str;
		}
		public int getValue() {
			return this.status;
		}
		public String toString() {
			return this.str;
		}
	};
	
	
	public void setAuctionStatus(AuctionStatus status){
		this.status = status.getValue();
	}

	public AuctionStatus getAuctionStatus(){
		switch (this.status) {
		case 0:
			return AuctionStatus.SUSPENDED;
		case 1:
			return AuctionStatus.ACTIVE;
		case 2:
			return AuctionStatus.AWAITING;
		case 3:
			return AuctionStatus.ENDEDSOLD;
		case 4:
			return AuctionStatus.ENDEDNOTSOLD;
		}
		return null;
	}
	
	public String getStatusMessage(){
		switch (this.status) {
		case 0:
			return AuctionStatus.SUSPENDED.toString();
		case 1:
			return AuctionStatus.ACTIVE.toString();
		case 2:
			return AuctionStatus.AWAITING.toString();
		case 3:
			return AuctionStatus.ENDEDSOLD.toString();
		case 4:
			return AuctionStatus.ENDEDNOTSOLD.toString();
		}
		return "Status Unknown";
	}
}
