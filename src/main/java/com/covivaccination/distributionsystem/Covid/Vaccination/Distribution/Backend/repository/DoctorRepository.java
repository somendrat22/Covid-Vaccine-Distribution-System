package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.repository;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    @Query(value = "select * from doctor where vaccination_center_id=:vcid and patient_count = (select min(patient_count) from doctor where vaccination_center_id=:vcid)", nativeQuery = true)
    public List<Doctor> getMinimumDoctorOnTheBasisOfVC(UUID vcid);
}
