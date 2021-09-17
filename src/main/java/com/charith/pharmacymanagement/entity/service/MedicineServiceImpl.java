package com.charith.pharmacymanagement.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charith.pharmacymanagement.entity.Medicine;
import com.charith.pharmacymanagement.repository.MedicineServiceRepository;


@Service
public class MedicineServiceImpl implements MedicineService {
	
	
	
	private MedicineServiceRepository medicineservicerepository;
	
	
	//Dependency injection(Constructor)
	@Autowired
	public MedicineServiceImpl(MedicineServiceRepository medicineservicerepository) {
		this.medicineservicerepository = medicineservicerepository;
	}

	@Override
	public List<Medicine> findAllMedicine() {
	
		return medicineservicerepository.findAll();
	}

	@Override
	public Medicine getMedicineById(int id) {
		Medicine medicine = null;
		Optional <Medicine> result = medicineservicerepository.findById(id);
		if(result.isPresent()) {
			medicine = result.get();
		}else {
			throw new RuntimeException("Not Found");
		}
		return medicine;		
	}

	@Override
	public void deleteMedicine(int id) {
		
		medicineservicerepository.deleteById(id);
		
	}

	@Override
	public void saveMedicine(Medicine medicine) {
		
		medicineservicerepository.save(medicine);
	

	}

}
