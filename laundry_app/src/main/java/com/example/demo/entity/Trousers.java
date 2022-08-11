package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trousers {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    int pant;
    int shirt;
    int pair;
    int saree;
    int tshirt;
    String date;




    public Trousers(int shirt, int pant, int saree, int tshirt, String pickupdate) {
        this.shirt=shirt;
        this.saree=saree;
        this.date=pickupdate;
        this.tshirt=tshirt;
        this.pant=pant;
    }
}
