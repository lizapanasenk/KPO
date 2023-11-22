package com.carpark.model;

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
        return "Truck";
    }
}
