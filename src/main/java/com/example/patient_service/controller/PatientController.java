package com.example.patient_service.controller;

import com.example.patient_service.data.Patient;
import com.example.patient_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping(path = "/patients/{p_id}")
    public Patient getPatientbyId(@PathVariable int p_id){
        return patientService.getPatientById(p_id);
    }

    @PostMapping("/patients")
    public String createPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping("/patients")
    public String updatePatient(@RequestBody Patient patient){

        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/patients/{p_id}")
    public String deletePatient(@PathVariable int p_id) {
        return patientService.deletePatient(p_id);

    }
}
