package org.telmoudy.hospital.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.telmoudy.hospital.dao.DoctorRepository;
import org.telmoudy.hospital.entities.Doctor;
import org.telmoudy.hospital.entities.Patient;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    public Page<Doctor> getDoctorByReference(String reference, int page, int size) {
        return this.doctorRepository.findByLastNameContainsIgnoreCase(reference, PageRequest.of(page,size));
    }
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor saveOrUpdateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}