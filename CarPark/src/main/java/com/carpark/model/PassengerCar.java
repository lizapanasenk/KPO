package com.carpark.model;

import java.util.Date;

public class PassengerCar extends ParkVisitor{

    public PassengerCar(Date movedIn, int weight, String nameOfParkVisitor) {
        super(movedIn, weight, nameOfParkVisitor);
    }

    @Override
    public int getPrice() {
        return 4;
    }

    @Override
    public String getNameOfCar() {
        return "PassengerCar";
    }
}
