package com.charith.pharmacymanagement.entity.service;

import java.util.List;

import com.charith.pharmacymanagement.entity.Supplier;

public interface SupplierService {
	
	List<Supplier> findAllSuppliers();
	
	Supplier getSupplierById(int id);
	
	void deleteSupplier(int id);
	
	void saveSupplier(Supplier supplier);
	
	

}
