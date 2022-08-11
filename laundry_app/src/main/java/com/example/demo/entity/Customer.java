package com.example.demo.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Customer {
    private String name;
    @Id
    private long phno;
    private String address;

    public Customer() {
    }

    public Customer(String name, long phno, String address) {
        this.name = name;
        this.phno = phno;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhno() {
        return phno;
    }

    public void setPhno(long phno) {
        this.phno = phno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
