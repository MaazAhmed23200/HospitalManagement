package com.example.HospitalManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HospitalManagement.Doctor;

import com.example.HospitalManagement.DoctorRepo;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
