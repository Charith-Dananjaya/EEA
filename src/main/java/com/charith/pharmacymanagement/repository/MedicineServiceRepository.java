package com.charith.pharmacymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charith.pharmacymanagement.entity.Medicine;

public interface MedicineServiceRepository extends JpaRepository<Medicine, Integer> {

}
