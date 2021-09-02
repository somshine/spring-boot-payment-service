package com.somshine.paymentService.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="shoppe_id", nullable=false, unique=false)
	private Integer shoppeId;
	@Column(name="first_name", nullable=false, unique=false)
	private String firstName;
	@Column(name="middle_name", nullable=false, unique=false)
	private String middleName;
	@Column(name="last_name", nullable=false, unique=false)
	private String lastName;
	@Column(name="mobile_no", nullable=false, unique=false)
	private String mobileNo;
	@Column(name="email_address", nullable=false, unique=false)
	private String emailAddress;
	private String address;
	private String username;
	private String password;
	@Column(name = "access_type_id")
	private Integer accessTypeId;
	
	public User() {
		super();
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(Long id, Integer shoppeId, String firstName, String middleName, String lastName, String mobileNo,
			String emailAddress, String address, String username, Integer accessTypeId) {
		super();
		this.id = id;
		this.shoppeId = shoppeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailAddress = emailAddress;
		this.address = address;
		this.username = username;
		this.accessTypeId = accessTypeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getShoppeId() {
		return shoppeId;
	}

	public void setShoppeId(Integer shoppeId) {
		this.shoppeId = shoppeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAccessTypeId() {
		return accessTypeId;
	}

	public void setAccessTypeId(Integer accessTypeId) {
		this.accessTypeId = accessTypeId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", shoppeId=" + shoppeId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", emailAddress=" + emailAddress + ", address="
				+ address + ", username=" + username + ", password=" + password + ", accessTypeId=" + accessTypeId
				+ "]";
	}
}
