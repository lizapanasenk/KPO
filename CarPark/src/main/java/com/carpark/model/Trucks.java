package com.carpark.model;

import java.util.Date;

public class Trucks extends ParkVisitor{

    public Trucks(Date movedIn, Date movedOut, int weight, String nameOfParkVisitor) {
        super(movedIn, movedOut, weight, nameOfParkVisitor);
    }

    @Override
    public String getNameOfParkVisitor() {
        return "TrucksCar";
    }
}
