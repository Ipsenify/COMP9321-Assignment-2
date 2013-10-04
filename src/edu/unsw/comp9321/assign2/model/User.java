package edu.unsw.comp9321.assign2.model;

import java.util.Comparator;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.unsw.comp9321.assign2.logic.ConfirmationService;

@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uid", updatable = false)
	Long id;

	@Column(name = "username")
	String userName;

	@Column(name = "password")
	String password;

	@Column(name = "firstname")
	String firstName;

	@Column(name = "lastname")
	String lastName;

	@Column(name = "nickname")
	String nickName;

	@Column(name = "email")
	String email;

	@Column(name = "yearofbirth")
	int yearOfBirth;

	@Column(name = "fulladdress")
	String fullAddress;

	@Column(name = "creditcardnumber")
	String creditCardNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastvisit_at", nullable = false)
	Date lastvisit_at;

	@Column(name = "superuser")
	int superUser;

	@Column(name = "status")
	int status;

	@Column(name = "confirmationurl")
	String confirmationUrl;

	@OneToMany(mappedBy = "author", fetch=FetchType.LAZY)
	//@Sort(type = SortType.COMPARATOR, comparator = AuctionComparator.class)
	Set<Auction> auctions;

	public enum UserStatus {
		NOTVERIFIED(0, "Not Verified"), VERIFIED(1, "Active"), BANNED(-1,
				"Banned");

		private int status;
		private String str;

		private UserStatus(int status, String str) {
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

	@PrePersist
	protected void onCreate() {
		this.lastvisit_at = created_at = new Date();
		this.status = UserStatus.NOTVERIFIED.getValue();
		this.setSuperUser(0);
		// Create confirmation URL
		this.confirmationUrl = ConfirmationService.generateUrl();
	}

	public void onLogin() {
		this.lastvisit_at = new Date();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getLastvisit_at() {
		return lastvisit_at;
	}

	public void setLastvisit_at(Date lastvisit_at) {
		this.lastvisit_at = lastvisit_at;
	}

	public int getSuperUser() {
		return superUser;
	}

	public void setSuperUser(int superUser) {
		this.superUser = superUser;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getConfirmationUrl() {
		return confirmationUrl;
	}

	public void setConfirmationUrl(String confirmationUrl) {
		this.confirmationUrl = confirmationUrl;
	}

	public Set<Auction> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(Set<Auction> auctions) {
		this.auctions = auctions;
	}

	public String getFullName() {
		if (this.nickName != null && !this.nickName.isEmpty()) {
			return this.nickName;
		}
		return this.firstName + " " + this.lastName;
	}

	public String getShortenedCreditCard() {
		if (this.creditCardNumber != null && this.creditCardNumber.length() > 4) {
			return this.creditCardNumber.substring(
					this.creditCardNumber.length() - 4,
					this.creditCardNumber.length());
		}
		return "****";
	}

	public String getStatusMessage() {
		switch (this.status) {
		case 0:
			return UserStatus.NOTVERIFIED.toString();
		case 1:
			return UserStatus.VERIFIED.toString();
		case -1:
			return UserStatus.BANNED.toString();
		}
		return "Status Unknown";
	}


	public void setUserStatus(UserStatus status) {
		this.status = status.getValue();
	}
	
	public UserStatus getUserStatus(){
		switch (this.status) {
		case 0:
			return UserStatus.NOTVERIFIED;
		case 1:
			return UserStatus.VERIFIED;
		case -1:
			return UserStatus.BANNED;
		}
		return null;
	}

	public class AuctionComparator implements Comparator<Auction> {

		@Override
		public int compare(Auction arg0, Auction arg1) {
			if(arg0 != null && arg1 != null){
				if (arg0.getId() > arg1.getId()) {
					return 1;
				} else if (arg0.getId() < arg1.getId()) {
					return -1;
				}
			}
			return 0;
		}

	}
}
