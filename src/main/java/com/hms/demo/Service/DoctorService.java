package com.hms.demo.Service;

import com.hms.demo.Repository.DoctorRepository;
import com.hms.demo.Repository.PatientRepository;
import com.hms.demo.models.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    public static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public List<Doctor> getDoctors() {
        try{
            List<Doctor> doctors = new ArrayList<Doctor>();
            return doctorRepository.findAll();
        }
        catch (Exception e){
            System.out.println("DoctorService getDoctors" + e.getMessage());
            logger.error("DoctorService getDoctors" + e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        try{
            doctorRepository.save(doctor);
            return doctor;
        }
        catch (Exception e){
            System.out.println("DoctorService createDoctor" + e.getMessage());
            logger.error("DoctorService createDoctor" + e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(int id) {
        try{
            Optional<Doctor> doc = doctorRepository.findById(id);
            return doc.orElse(null);
        }
        catch (Exception e){
            System.out.println("DoctorService getDoctorById" + e.getMessage());
            logger.error("DoctorService getDoctorById" + e.getMessage());
            return null;
        }
    }

    public void deleteDoctorById(int id) {
        try {
            logger.info("DoctorService deleteDoctorById" + id);
            doctorRepository.deleteById(id);
        }
        catch (Exception e){
            System.out.println("DoctorService deleteDoctorById" + e.getMessage());
            logger.error("DoctorService deleteDoctorById" + e.getMessage());
        }
    }


    public Doctor updateDoctorById(int id, Doctor doctor) {
        try{
            Optional<Doctor> existingdoctor = doctorRepository.findById(id);
            if(existingdoctor.isPresent()) {
                Doctor d = existingdoctor.get();
                d.setFirstName(doctor.getFirstName());
                d.setLastName(doctor.getLastName());
                d.setAge(doctor.getAge());
                d.setGender(doctor.getGender());
                doctorRepository.save(d);
                return doctor;
            }
            else{
                logger.error("DoctorService updateDoctorById" + id);
                return null;
            }
        }
        catch (Exception e){
            System.out.println("DoctorService updateDoctorById" + e.getMessage());
            logger.error("DoctorService updateDoctorById" + e.getMessage());
            return null;
        }
    }

}
