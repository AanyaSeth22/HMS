package com.hms.demo.Controllers;

import com.hms.demo.Repository.DoctorRepository;
import com.hms.demo.Service.DoctorService;
import com.hms.demo.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/doctors")
public class DoctorController {

    @Autowired
    public DoctorService doctorService;
    @GetMapping
    public List<Doctor> getDoctor(){
//        List<Doctor> doctors = new ArrayList<Doctor>();
        return doctorService.getDoctors();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        System.out.println("creating");
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id){
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable int id){
        System.out.println("delete");
        doctorService.deleteDoctorById(id);
    }

    @PutMapping("/{id}")
    public void updateDoctorById(@PathVariable int id, @RequestBody Doctor doctor){
        System.out.println("update");
        doctorService.updateDoctorById(id, doctor);
    }
}
