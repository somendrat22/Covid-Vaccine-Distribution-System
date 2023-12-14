package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.service;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.VaccinationCenter;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenter registerVaccinationCenter(VaccinationCenter vaccinationCenter){
        vaccinationCenterRepository.save(vaccinationCenter); // It is going to save Vaccination center object in the database
        return vaccinationCenter;
    }


    public List<VaccinationCenter> getMinimumDoctorCountVC(){
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterRepository.getMinimumDoctorVaccinationCenter();
        return vaccinationCenters;
    }

    public void updateDocCountByOne(VaccinationCenter vaccinationCenter){
        UUID id = vaccinationCenter.getId();
        int docCount =  vaccinationCenter.getDoctorCount() + 1;
        vaccinationCenterRepository.updateDocCountByOne(id, docCount);
    }

    public List<VaccinationCenter> getMinimumVCOnTheBasisOfTypeAndPrefrence(String type, String prefrence){
        if(prefrence.equals("Sputnik")){
            return vaccinationCenterRepository.getAllVcOntheBasisOfTypeAndSputnikCount(type);
        }else if(prefrence.equals("Covishield")){
            return vaccinationCenterRepository.getAllVcOntheBasisOfTypeAndCovishieldCount(type);
        }else{
            return vaccinationCenterRepository.getAllVCOntheBasisOfTypeAndCovaxinCount(type);
        }
    }

}
