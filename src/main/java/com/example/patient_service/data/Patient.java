package com.example.patient_service.data;

import javax.persistence.*;

@Entity
@Table(name= "patient_tlb")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;
    @Column(name = "p_name")
    private String p_name;

    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "tp")
    private int tp;
    @Column(name = "p_add")
    private String address;
    @Column(name = "email")
    private  String email;


    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
