package com.charith.pharmacymanagement.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charith.pharmacymanagement.entity.Pharmacist;

import com.charith.pharmacymanagement.repository.PharmacistServiceRepository;



@Service
public class PharmacistSeviceImpl implements PharmacistService {
	
	
	private PharmacistServiceRepository pharmacistservicerepository;
	
	
	//Dependency injection(Constructor)
	@Autowired
	public PharmacistSeviceImpl(PharmacistServiceRepository pharmacistservicerepository) {
		this.pharmacistservicerepository = pharmacistservicerepository;
	}
	

	@Override
	public List<Pharmacist> findAllPharmacists() {
	
		return pharmacistservicerepository.findAll();
	}

	@Override
	public Pharmacist getPharmacistById(int id) {
		
		Pharmacist pharmacist = null;
		Optional <Pharmacist> result = pharmacistservicerepository.findById(id);
		if(result.isPresent()) {
			pharmacist = result.get();
		}else {
			throw new RuntimeException("Not Found");
		}
		return pharmacist;
		
	}

	@Override
	public void deletePharmacist(int id) {
	
		pharmacistservicerepository.deleteById(id);
	}

	@Override
	public void savePharmacist(Pharmacist pharmacist) {
		pharmacistservicerepository.save(pharmacist);
		
	}

}
