package com.carpark.model;

import java.io.Serializable;
import java.util.Date;

public class ParkVisitor implements Serializable {

    protected Date movedIn;
    protected final int weight;

    protected final String name;


    public ParkVisitor(Date movedIn, int weight, String name) {
        this.movedIn = movedIn;
        this.weight = weight;
        this.name = name;
    }
    public int getPrice(){
        return 5;
    }
    public Date getMovedIn() {
        return movedIn;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.movedIn = date;
    }
    public String getNameOfCar(){
        return "";
    }
    @Override
    public String toString() {
        return "Type - "+ getNameOfCar() +" Name - "+getName()+" Weight - "+getWeight()+" Price - "+getPrice()+"Date of moved in - "+getMovedIn()+"\n";

    }
}
