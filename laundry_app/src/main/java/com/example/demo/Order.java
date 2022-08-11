package com.example.demo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order
{
    String trouserName;
    int  quantity;
    String typeOfWash;
    int rate;
    int amount;



}
