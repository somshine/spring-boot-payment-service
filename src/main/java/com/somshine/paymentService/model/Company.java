package com.somshine.paymentService.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "shoppe_id")
	private int shoppeId;
	private String name;
	private String description;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "deleted")
	private int deleted;
	
	public Company() {
		super();
	}

	public Company(Long id, int shoppeId, String name, String description, String mobileNo, String emailAddress, int deleted) {
		super();
		this.id = id;
		this.shoppeId = shoppeId;
		this.name = name;
		this.description = description;
		this.mobileNo = mobileNo;
		this.emailAddress = emailAddress;
		this.deleted = deleted;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getShoppeId() {
		return shoppeId;
	}

	public void setShoppeId(int shoppeId) {
		this.shoppeId = shoppeId;
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

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
