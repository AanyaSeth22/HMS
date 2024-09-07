package com.hms.demo.Service;

import com.hms.demo.Repository.PatientRepository;
import com.hms.demo.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getPatients() {
        try{
            List<Patient> patients = new ArrayList<Patient>();
            System.out.println("service layer getPatients");
            return patientRepository.findAll();
        }
        catch (Exception e){
            System.out.println("error getting patients" + e.getMessage());
            logger.error("an error occured while fetching" , e.getMessage());
            return null;
        }
    }
    public Patient getPatient(int id) {
        try {
            Optional<Patient> patient =  patientRepository.findById(id);
            return patient.orElse(null);
        }
        catch (Exception e){
            System.out.println("error getting patient" + e.getMessage());
            logger.error("an error occured while fetching" , id ,e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient) {
        try {
            patientRepository.save(patient);
            return patient;
        }
        catch (Exception e){
            System.out.println("error creating patient" + e.getMessage());
            logger.error("an error occured while fetching" , e.getMessage());
            return null;
        }
    }
    public Patient updatePatientById(int id,Patient patient) {
        try {
            Optional<Patient> existingpatient =  patientRepository.findById(id);
            if(existingpatient.isPresent()){
                Patient p = existingpatient.get();
                p.setFirstName(patient.getFirstName());
                p.setLastName(patient.getLastName());
                p.setAge(patient.getAge());
                p.setGender(patient.getGender());
                patientRepository.save(p);
                return patient;
            }
            else {
                logger.error("Patient with id{} not found ", id);
                return null;
            }
        }
        catch (Exception e){
            System.out.println("error updating patient" + e.getMessage());
            logger.error("an error occured while fetching" , id ,e.getMessage());
            return null;
        }
    }
    public void deletePatient(int id) {
        try {
            logger.info("deleting patient with id " + id);
            patientRepository.deleteById(id);
        }
        catch (Exception e){
            System.out.println("error deleting patient" + e.getMessage());
            logger.error("an error occured while fetching" , id ,e.getMessage());
        }
    }

}
