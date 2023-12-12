package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    String gender;
    @Column(unique = true)
    int aadharNumber;
    int doseCount;










    
    String vaccinationPrefrence;
    String address;
    @Column(unique = true)
    long phoneNumber;
    @Column(unique = true)
    String email;

    public Patient(UUID id, String name, String gender, int aadharNumber, int doseCount, String vaccinationPrefrence, String address, long phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.aadharNumber = aadharNumber;
        this.doseCount = doseCount;
        this.vaccinationPrefrence = vaccinationPrefrence;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Patient() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getDoseCount() {
        return doseCount;
    }

    public void setDoseCount(int doseCount) {
        this.doseCount = doseCount;
    }

    public String getVaccinationPrefrence() {
        return vaccinationPrefrence;
    }

    public void setVaccinationPrefrence(String vaccinationPrefrence) {
        this.vaccinationPrefrence = vaccinationPrefrence;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
