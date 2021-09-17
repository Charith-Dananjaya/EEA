package com.charith.pharmacymanagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="drug_id")
	private int medId;
	
	@Column(name="pharmacist_id")
	private int pharmacistId;
	
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="status")
	private String status;
	
	public Order() {
		
	}

	public Order(int id, int medId, int pharmacistId, int supplierId, String orderDate, String amount, String status) {
		super();
		this.id = id;
		this.medId = medId;
		this.pharmacistId = pharmacistId;
		this.supplierId = supplierId;
		this.orderDate = orderDate;
		this.amount = amount;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public int getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(int pharmacistId) {
		this.pharmacistId = pharmacistId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", medId=" + medId + ", pharmacistId=" + pharmacistId + ", supplierId=" + supplierId
				+ ", orderDate=" + orderDate + ", amount=" + amount + ", status=" + status + "]";
	}
	
	
	

}
