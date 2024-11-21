package com.example.hospitalMT.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hospitalMT.model.Appointment;
import com.example.hospitalMT.repository.AppointmentRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v2")
public class AppointmentController {
 
    AppointmentRepository appointmentRepository;
	public AppointmentController(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}
	@PostMapping("/insert")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
	return appointmentRepository.save(appointment);
			}
	@GetMapping("/appointments")
	public List<Appointment>getAllAppointment(){
		return appointmentRepository.findAll();
	}
	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException{
		Appointment appointment = appointmentRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appointment not Found with id" +id));
		appointmentRepository.delete(appointment);
		Map<String, Boolean> response=new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
