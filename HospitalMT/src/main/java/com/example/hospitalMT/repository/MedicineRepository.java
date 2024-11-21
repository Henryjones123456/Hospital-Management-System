package com.example.hospitalMT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalMT.model.Medicine;
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
