package com.charith.pharmacymanagement.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charith.pharmacymanagement.entity.Supplier;
import com.charith.pharmacymanagement.repository.SupplierServiceRepository;


@Service
public class SupplierServiceImpl implements SupplierService {
	
	
	@Autowired
	private SupplierServiceRepository supplierservicerepository;
	

	@Override
	public List<Supplier> findAllSuppliers() {
		
		return supplierservicerepository.findAll();
		
	}

	@Override
	public Supplier getSupplierById(int id) {
		
		Supplier supplier = null;
		Optional <Supplier> result = supplierservicerepository.findById(id);
		if(result.isPresent()) {
			supplier = result.get();
		}else {
			throw new RuntimeException("Not Found");
		}
		return supplier;
		
	}

	@Override
	public void deleteSupplier(int id) {
		
		supplierservicerepository.deleteById(id);
		
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		
		supplierservicerepository.save(supplier);
		
	}


}
