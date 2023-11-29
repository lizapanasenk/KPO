package com.carpark.model;

import com.carpark.controller.LocalManager;

import java.util.Date;

public class Trucks extends ParkVisitor{

    public Trucks(Date movedIn,  int weight, String nameOfParkVisitor) {
        super(movedIn, weight, nameOfParkVisitor);
    }
    @Override
    public int getPrice() {
        return 10;
    }
    @Override
    public String getNameOfCar() {
        return LocalManager.getMessage().getString("Truck");
    }
}
