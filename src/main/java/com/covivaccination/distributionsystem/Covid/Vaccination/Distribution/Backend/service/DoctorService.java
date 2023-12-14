package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.service;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.Doctor;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.VaccinationCenter;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    // Doctor will get assigned in that vaccination center who is having minimum number of doctor
    public Doctor registerDoctor(Doctor obj){
        List<VaccinationCenter> vaccinationCenterList = vaccinationCenterService.getMinimumDoctorCountVC();
        VaccinationCenter vaccinationCenter = vaccinationCenterList.get(0);
        obj.setVaccinationCenter(vaccinationCenter);
        vaccinationCenterService.updateDocCountByOne(vaccinationCenter);
        doctorRepository.save(obj);
        return obj;
    }

    public List<Doctor> getMinimumDoctorOnTheBasisOfVC(UUID vcid){
        return doctorRepository.getMinimumDoctorOnTheBasisOfVC(vcid);
    }
}
