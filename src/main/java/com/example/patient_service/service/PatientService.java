package com.example.patient_service.service;

import com.example.patient_service.data.Patient;
import com.example.patient_service.data.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public Patient getPatientById(int p_id) {
        Optional<Patient> patient = patientRepository.findById(p_id);
        return patient.orElse(null);
    }
    public String addPatient(Patient patient) {
        patientRepository.save(patient);
        return patient.getP_name() + " has been successfully added";
    }

    public String updatePatient(Patient patient) {
        patientRepository.save(patient);
        return patient.getP_name() + "'s contents has been updated successfully";
    }

    public String deletePatient(int p_id) {
        patientRepository.deleteById(p_id);
        return "Employee with id " + p_id + " has been successfully deleted";
    }


}
