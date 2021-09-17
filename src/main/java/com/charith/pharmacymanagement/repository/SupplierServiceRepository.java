package com.charith.pharmacymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charith.pharmacymanagement.entity.Supplier;

public interface SupplierServiceRepository extends JpaRepository<Supplier, Integer> {

}
