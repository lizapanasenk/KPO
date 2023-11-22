package com.carpark.model;

import java.util.Date;

public class FreightCar extends ParkVisitor{

    public FreightCar(Date movedIn, Date movedOut, int weight, String nameOfParkVisitor) {
        super(movedIn, movedOut, weight, nameOfParkVisitor);
    }
    @Override
    public int getPrice() {
        return 8;
    }
    @Override
    public String getName() {
        return "FreightCar";
    }
}
