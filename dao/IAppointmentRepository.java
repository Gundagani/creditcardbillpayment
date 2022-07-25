package com.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.models.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long>{


	Appointment findByAppointmentId(long appointmentId);
	
}
