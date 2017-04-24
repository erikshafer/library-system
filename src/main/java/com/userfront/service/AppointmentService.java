package com.userfront.service;

import java.util.List;

import com.userfront.domain.Appointment;
import com.userfront.domain.User;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

    List<Appointment> findAll();

    Appointment findAppointment(Long id);

    void confirmAppointment(Long id);
    
    List<Appointment> findByUser(User user);
}
