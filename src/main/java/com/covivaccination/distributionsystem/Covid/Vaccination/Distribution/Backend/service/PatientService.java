package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.service;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.request.PatientSignupDTO;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.Patient;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public Patient signUp(PatientSignupDTO patientSignupDTO){
        Patient patient = new Patient();
        patient.setName(patientSignupDTO.getName());
        patient.setGender(patientSignupDTO.getGender());
        patient.setEmail(patientSignupDTO.getEmail());
        patient.setAddress(patientSignupDTO.getAddress());
        patient.setAadharNumber(patientSignupDTO.getAadharNumber());
        patient.setPassword(patientSignupDTO.getPassword());
        patient.setPhoneNumber(patientSignupDTO.getPhoneNumber());
        patient.setVaccinationPrefrence(patientSignupDTO.getVaccinationPrefrence().toString());
        patientRepository.save(patient);
        return patient;
    }

    
}
