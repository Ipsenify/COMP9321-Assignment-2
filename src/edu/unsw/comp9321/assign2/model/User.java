package edu.unsw.comp9321.assign2.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid", updatable = false, nullable = false)
	Long uid;
	
	@Column(name="username")
	String userName;

	@Column(name="password")
	String password;
	
	@Column(name="firstname")
	String firstName;
	
	@Column(name="lastname")
	String lastName;
	
	@Column(name="nickname")
	String nickName;
	
	@Column(name="email")
	String email;
	
	@Column(name="yearofbirth")
	int yearOfBirth;
	
	@Column(name="fulladdress")
	String fullAddress;
	
	@Column(name="creditcardnumber")
	String creditCardNumber;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
	Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastvisit_at", nullable = false)
	Date lastvisit_at;
	
	@Column(name="superuser")
	int superUser;
	
	@Column(name="status")
	int status;
	
	@PrePersist
    protected void onCreate() {
		lastvisit_at = created_at = new Date();
    }
	
	public void onLogin() {
		lastvisit_at = new Date();
    }
    
	public Long getUserId(){
		return this.uid;
	}
	
	public void setUserId(Long userId){
		this.uid = userId;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserName(String userName){
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
}

