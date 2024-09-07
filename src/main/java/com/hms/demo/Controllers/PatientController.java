package com.hms.demo.Controllers;

import com.hms.demo.Service.PatientService;
import com.hms.demo.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping
    public List<Patient> getPatients() {
        System.out.println("fetching");
        return patientService.getPatients();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        System.out.println("creating");
        return patientService.createPatient(patient);
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id){
        return patientService.getPatient(id);
    }

    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable int id){
        System.out.println("delete");
        patientService.deletePatient(id);
    }

    @PutMapping("/{id}")
    public void updatePatientById(@PathVariable int id, @RequestBody Patient patient){
        System.out.println("update");
        patientService.updatePatientById(id, patient);
    }

}
