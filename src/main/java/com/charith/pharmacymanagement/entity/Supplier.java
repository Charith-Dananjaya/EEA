package com.charith.pharmacymanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="suppliers")
public class Supplier {
	
	
	
	@Id
	@Column(name ="id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mfg_license")
	private String mfgLicense;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	
	
	
	//no argument constructor 
	public Supplier () {
		
	}
	
	
	//constructor using fields
	public Supplier(int id, String name, String mfgLicense, String address, String email) {
		super();
		this.id = id;
		this.name = name;
		this.mfgLicense = mfgLicense;
		this.address = address;
		this.email = email;
	}


	public Integer getId() {
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


	public String getMfgLicense() {
		return mfgLicense;
	}


	public void setMfgLicense(String mfgLicense) {
		this.mfgLicense = mfgLicense;
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


	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", mfgLicense=" + mfgLicense + ", address=" + address
				+ ", email=" + email + "]";
	}
	
	
	
	

}
