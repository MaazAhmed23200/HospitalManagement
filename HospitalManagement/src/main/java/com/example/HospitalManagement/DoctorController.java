package com.example.HospitalManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.HospitalManagement.Doctor;
import com.example.HospitalManagement.DoctorRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorRepo repo;

    @Autowired
    public DoctorController(DoctorRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }

    @GetMapping("/{docId}")
    public Doctor getDoctorById(@PathVariable("docId") int docId) {
        return repo.findById(docId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + docId));
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor newDoctor = repo.save(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDoctor);

    }

    @PutMapping("/update/{id}")
    public Doctor updateDoctors(@PathVariable int id) {
        Doctor doctor = repo.findById(id).get();
        doctor.setName("Takreem");
        doctor.setSpecilization("eye");
        repo.save(doctor);
        return doctor;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeDoctor(@PathVariable int id) {
        Doctor doctor = repo.findById(id).get();
        repo.delete(doctor);
    }
}

