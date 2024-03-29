package com.carpark.controller;

import com.carpark.model.*;

import java.util.Date;
import java.util.Random;

public class Post {

    private final ParkVisitors parkVisitors;

    public Post() {
        this.parkVisitors = new ParkVisitors();
        parkVisitors.add(new FreightCar(new Date(),2000,"Caboose" ));
        parkVisitors.add(new FreightCar(new Date(),2200,"Refrigerator car" ));
        parkVisitors.add(new FreightCar(new Date(),2100,"Intermodal car" ));
        parkVisitors.add(new PassengerCar(new Date(),1500,"Toyota" ));
        parkVisitors.add(new PassengerCar(new Date(),1700,"Mercedes" ));
        parkVisitors.add(new PassengerCar(new Date(),1600,"Audi" ));
        parkVisitors.add(new Trucks(new Date(),1500,"Tank car" ));
        parkVisitors.add(new Trucks(new Date(),1500,"Box car" ));

    }
    public String addCar(CarPark carPark){
        Random random = new Random();
        ParkVisitor parkVisitor =parkVisitors.get(random.nextInt(parkVisitors.size()));
        parkVisitor.setDate(new Date());
        carPark.addParkVisitor(parkVisitor);
        return parkVisitor +LocalManager.getMessage().getString("AddOnPost")+" \n";
    }
    public String addCarHurd(CarPark carPark){
        StringBuilder all = new StringBuilder();
        for (int i = 0; i < 20; i++)
            all.append(addCar(carPark));
        return all.toString();
    }
}
