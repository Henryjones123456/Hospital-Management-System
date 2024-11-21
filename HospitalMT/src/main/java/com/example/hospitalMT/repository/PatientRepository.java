package com.example.hospitalMT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalMT.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
