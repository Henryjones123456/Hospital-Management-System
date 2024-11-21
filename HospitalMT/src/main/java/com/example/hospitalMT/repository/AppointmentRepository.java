package com.example.hospitalMT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalMT.model.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
