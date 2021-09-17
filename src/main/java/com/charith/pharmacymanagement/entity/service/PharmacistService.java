package com.charith.pharmacymanagement.entity.service;

import java.util.List;

import com.charith.pharmacymanagement.entity.Pharmacist;



public interface PharmacistService {

	List<Pharmacist> findAllPharmacists();
	
	Pharmacist getPharmacistById(int id);
	
	void deletePharmacist(int id);
	
	void savePharmacist(Pharmacist pharmacist);
	
	
	
}
