package com.example.hospitalMT.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalMT.model.Appointment;
import com.example.hospitalMT.model.Medicine;
import com.example.hospitalMT.repository.MedicineRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {
	MedicineRepository medicineRepository;
	
	public MedicineController(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}

	@PostMapping("/medicines")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
	return medicineRepository.save(medicine);
			}
	@GetMapping("/medicines")
	public List<Medicine>getAllMedicine(){
		return medicineRepository.findAll();
	}
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not Found with id" +id));
		return ResponseEntity.ok(medicine);
	}
	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable long id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not Found with id" +id));
		medicine.setDrugname(medicineDetails.getDrugname());
		medicine.setStock(medicineDetails.getStock());
		medicineRepository.save(medicine);
		return ResponseEntity.ok(medicine);
	}
	@DeleteMapping("/medicines/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteMedicine(@PathVariable long id) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not Found with id" +id));
		medicineRepository.delete(medicine);
		Map<String, Boolean> response=new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
