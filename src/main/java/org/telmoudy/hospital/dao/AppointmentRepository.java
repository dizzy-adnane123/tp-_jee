package org.telmoudy.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telmoudy.hospital.entities.Appointment;
import org.telmoudy.hospital.entities.Doctor;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {


}
