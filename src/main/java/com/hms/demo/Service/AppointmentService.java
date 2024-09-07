package com.hms.demo.Service;

import com.hms.demo.Repository.AppointmentRepository;
import com.hms.demo.Repository.BillRepository;
import com.hms.demo.models.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class AppointmentService {

    public static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    private BillRepository billRepository;

    public List<Appointment> getAppointments() {
        try{
            List<Appointment> appointments = new ArrayList<>();
            return appointmentRepository.findAll();
//            return null;
        }
        catch(Exception e){
            System.out.println("Error in getAppointments" + e.getMessage());
            logger.error("Error in getAppointments" + e.getMessage());
            return null;
        }
    }

    public Appointment getAppointment(int id) {
        try{
            Optional<Appointment> appointment = appointmentRepository.findById(id);
            return appointment.orElse(null);
        }
        catch(Exception e){
            System.out.println("Error in getAppointment" + e.getMessage());
            logger.error("Error in getAppointment" + e.getMessage());
            return null;
        }
    }
    public Appointment createAppointment(Appointment appointment) {
        try{
            appointmentRepository.save(appointment);
            return appointment;
        }
        catch(Exception e){
            System.out.println("Error in createAppointment" + e.getMessage());
            logger.error("Error in createAppointment" + e.getMessage());
            return null;
        }
    }

    public void deleteAppointmentById(int id) {
        try{
            logger.info("Deleting appointment with id: " + id);
            appointmentRepository.deleteById(id);
        }
        catch(Exception e){
            System.out.println("Error in deleteAppointmentById" + e.getMessage());
            logger.error("Error in deleteAppointmentById" + e.getMessage());
        }
    }

    public Appointment updateAppointmentById(Appointment appointment, int id) {
        try {
            Optional<Appointment> existingapp = appointmentRepository.findById(id);
            if(existingapp.isPresent()){
                Appointment a = existingapp.get();
                a.setAppointmentDate(appointment.getAppointmentDate());
                a.setId(appointment.getId());
                a.setAppointmentTime(appointment.getAppointmentTime());
                a.setDoctorId(appointment.getDoctorId());
                a.setDoctorName(appointment.getDoctorName());
                a.setPatientId(appointment.getPatientId());
                a.setPatientName(appointment.getPatientName());
                appointmentRepository.save(a);
                return appointment;
            }
            else{
                logger.error("Appointment not found");
                return null;
            }
        }
        catch(Exception e){
            System.out.println("Error in updateAppointmentById" + e.getMessage());
            logger.error("Error in updateAppointmentById" + e.getMessage());
            return null;
        }
    }
}
