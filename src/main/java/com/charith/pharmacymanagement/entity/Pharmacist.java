package com.charith.pharmacymanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pharmacist")
public class Pharmacist {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="license_number")
	private String licenseNumber;
	
	
	//no argument constructor
	public Pharmacist() {
		
	}


	public Pharmacist(int id, String name, String address, String email, String licenseNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.licenseNumber = licenseNumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	
	
	//to string method
	@Override
	public String toString() {
		return "Pharmacist [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", licenseNumber=" + licenseNumber + "]";
	}
	
	
	
	
	
	
	
	

}
