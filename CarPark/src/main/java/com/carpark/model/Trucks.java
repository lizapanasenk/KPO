package com.carpark.model;

import java.util.Date;

public class Trucks extends ParkVisitor{

    public Trucks(Date movedIn, Date movedOut, int weight, String nameOfParkVisitor) {
        super(movedIn, movedOut, weight, nameOfParkVisitor);
    }
    @Override
    public int getPrice() {
        return 10;
    }
    @Override
    public String getName() {
        return "Truck";
    }
}
