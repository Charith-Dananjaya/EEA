package com.charith.pharmacymanagement.entity;







import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="CSA")
	private String csa;
	
	@Column(name="batch_number")
	private String batchNumber;
	
	@Column(name="expire_date")
	private String expireDate;
	
	
	// No argument Constructor
	public Medicine() {
		
	}

	//Constructor with fields
	public Medicine(int id, String name, String csa, String batchNumber, String expireDate) {
		super();
		this.id = id;
		this.name = name;
		this.csa = csa;
		this.batchNumber = batchNumber;
		this.expireDate = expireDate;
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

	public String getCsa() {
		return csa;
	}

	public void setCsa(String csa) {
		this.csa = csa;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	
	
	//Tostring method
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", csa=" + csa + ", batchNumber=" + batchNumber
				+ ", expireDate=" + expireDate + "]";
	}
	
	
	
	
	
	
	

	
	
	

}
