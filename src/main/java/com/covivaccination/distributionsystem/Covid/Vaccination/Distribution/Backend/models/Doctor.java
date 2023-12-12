package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    String docDegree;
    @ManyToOne
    VaccinationCenter vaccinationCenter;
    int patientCount;
    @OneToMany
    List<Patient> patients;

    public Doctor() {
    }

    public Doctor(UUID id, String name, String docDegree, VaccinationCenter vaccinationCenter, int patientCount, List<Patient> patients) {
        this.id = id;
        this.name = name;
        this.docDegree = docDegree;
        this.vaccinationCenter = vaccinationCenter;
        this.patientCount = patientCount;
        this.patients = patients;
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

    public String getDocDegree() {
        return docDegree;
    }

    public void setDocDegree(String docDegree) {
        this.docDegree = docDegree;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
