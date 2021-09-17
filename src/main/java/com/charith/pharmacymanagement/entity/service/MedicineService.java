package com.charith.pharmacymanagement.entity.service;

import java.util.List;

import com.charith.pharmacymanagement.entity.Medicine;



public interface MedicineService {
	
	
	List<Medicine> findAllMedicine();
	
	Medicine getMedicineById(int id);
	
	void deleteMedicine(int id);
	
	void saveMedicine(Medicine medicine);
	

}
