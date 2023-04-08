package com.miit.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private int marksScored;
	private long contactNumber;
	
	public User() {

	}
	
	public User(String userName, int marksScored, long contactNumber) {
		super();
		this.userName = userName;
		this.marksScored = marksScored;
		this.contactNumber = contactNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", marksScored=" + marksScored + ", contactNumber="
				+ contactNumber + "]";
	}
	
}
