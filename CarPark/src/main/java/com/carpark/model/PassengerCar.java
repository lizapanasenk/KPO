package com.carpark.model;

import java.util.Date;

public class PassengerCar extends ParkVisitor{

    public PassengerCar(Date movedIn, Date movedOut, int weight, String nameOfParkVisitor) {
        super(movedIn, movedOut, weight, nameOfParkVisitor);
    }

    @Override
    public String getNameOfParkVisitor() {
        return "PassengerCar";
    }
}
