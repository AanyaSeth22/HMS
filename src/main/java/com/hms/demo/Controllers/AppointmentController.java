package com.hms.demo.Controllers;

import com.hms.demo.models.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Appointments")
public class AppointmentController {


    @GetMapping
    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<Appointment>();
        return appointments;
    }

    @PostMapping
    public void addAppointment(@RequestBody Appointment appointment) {
        return;
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable int id) {
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable int id) {
    }

    @PostMapping("{id}")
    public void updateAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
        System.out.println("update");
    }
}
