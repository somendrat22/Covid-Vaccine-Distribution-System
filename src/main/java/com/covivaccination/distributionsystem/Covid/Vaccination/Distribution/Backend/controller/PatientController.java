package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.controller;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.request.PatientSignupDTO;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.Patient;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.service.PatientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody PatientSignupDTO patientSignupDTO){
        Patient patient = patientService.signUp(patientSignupDTO);
        return new ResponseEntity(patient, HttpStatus.CREATED);
    }
}
