package com.charith.pharmacymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charith.pharmacymanagement.entity.Pharmacist;

public interface PharmacistServiceRepository extends JpaRepository<Pharmacist, Integer> {

}
