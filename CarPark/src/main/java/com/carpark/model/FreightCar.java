package com.carpark.model;

import java.util.Date;

public class FreightCar extends ParkVisitor{

    public FreightCar(Date movedIn, int weight, String nameOfParkVisitor) {
        super(movedIn,  weight, nameOfParkVisitor);
    }
    @Override
    public int getPrice() {
        return 8;
    }
    @Override
    public String getNameOfCar() {
        return "FreightCar";
    }
}
