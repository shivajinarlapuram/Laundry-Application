package com.example.demo.controller;

import com.example.demo.Order;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Trousers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TrouserController{

@GetMapping("/TrousersInputPage")
    public ModelAndView trouserInput(){
    ModelAndView mv= new ModelAndView();
    mv.setViewName("TrousersInputPage");
    return mv;
}
//=====================================================================================================
@GetMapping("/trouser")
    public ModelAndView trouser(HttpServletRequest req, HttpServletResponse res){
    ModelAndView mv= new ModelAndView();
    int shirt=Integer.parseInt(req.getParameter("shirts"));
    int pant=Integer.parseInt(req.getParameter("pants"));
    int saree=Integer.parseInt(req.getParameter("sarees"));
    int tshirt=Integer.parseInt(req.getParameter("tshirts"));
    String pickupdate=req.getParameter("pickupdate");
    int washRateSaree=0;
    int washRateShirt=0;
    int washRatetShirt=0;
    int washRatetpant=0;
    Trousers tr= new Trousers(shirt,pant,saree,tshirt,pickupdate);

    String wash= req.getParameter("wash");
     int totalCost = 0;
     int shirtCost=0;
     int sareeCost=0;
     int tShirtCost=0;
     int panCost=0;
     if(wash.equalsIgnoreCase("Normal")) {
         washRateSaree=30;
         washRateShirt=15;
         washRatetpant=20;
         washRatetShirt=15;
         shirtCost = shirt * washRateShirt;
         sareeCost = saree * washRateSaree;
         panCost = pant * washRatetpant;
         tShirtCost = tshirt * washRatetShirt;
         totalCost = shirtCost + sareeCost + panCost + tShirtCost;
     }
    if(wash.equalsIgnoreCase("Dry")) {
        washRateSaree=60;
        washRateShirt=30;
        washRatetpant=40;
        washRatetShirt=30;
        shirtCost = shirt * washRateShirt;
        sareeCost = saree * washRateSaree;
        panCost = pant * washRatetpant;
        tShirtCost = tshirt * washRatetShirt;
        totalCost = shirtCost + sareeCost + panCost + tShirtCost;
    }
    Order order1=new Order("shirt",shirt,wash,washRatetShirt,shirtCost);
    Order order2=new Order("saree",saree,wash,washRateSaree,sareeCost);
    Order order3=new Order("pant",pant,wash,washRatetpant,panCost);
    Order order4=new Order("tShirt",tshirt,wash,washRatetShirt,tShirtCost);

    List<Order> Ol = new ArrayList<>();
    Ol.add(order1);
    Ol.add(order2);
    Ol.add(order3);
    Ol.add(order4);

    mv.addObject("trouser",Ol);
    mv.addObject("details",tr);
    mv.addObject("pickup",pickupdate);
    mv.addObject("total",totalCost);
    mv.setViewName("TrouserResultPage");
    return mv;
}
//=======================================================================================================
}
