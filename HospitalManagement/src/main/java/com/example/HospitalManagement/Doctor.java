package com.example.HospitalManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DocId;
    @Column(name = "Doctor_name")
    private String name;
    @Column(name="Specilization")
    private String specilization;
    @Column(name="Phone_Number")
    private int PhoneNumber;


    public Doctor() {

    }

    public Doctor(String name, String specilization, int phoneNumber) {
        super();
        this.name = name;
        this.specilization = specilization;
        PhoneNumber = phoneNumber;
    }

    public int getDocId() {
        return DocId;
    }

    public void setDocId(int docId) {
        DocId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "DocId=" + DocId +
                ", name='" + name + '\'' +
                ", specilization='" + specilization + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
}

