package com.carpark.model;

import com.carpark.controller.LocalManager;

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
        return LocalManager.getMessage().getString("Type")+" "+ getNameOfCar()+" "
                +LocalManager.getMessage().getString("Name")+" " +getName()+" "
                +LocalManager.getMessage().getString("Weight")+" "+getWeight()+" "
                +LocalManager.getMessage().getString("Price")+" "+getPrice()+" \n"
                +LocalManager.getMessage().getString("DateMoveIn")+" "+getMovedIn()+" ";

    }
}
