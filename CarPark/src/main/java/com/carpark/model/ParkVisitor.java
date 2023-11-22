package com.carpark.model;

import java.util.Date;

public class ParkVisitor {

    protected final Date movedIn;
    protected final Date movedOut;
    protected final int weight;

    protected final String name;

    public ParkVisitor(Date movedIn, Date movedOut, int weight, String name) {
        this.movedIn = movedIn;
        this.movedOut = movedOut;
        this.weight = weight;
        this.name = name;
    }
    public int getPrice(){
        return 5;
    }
    public Date getMovedIn() {
        return movedIn;
    }

    public Date getMovedOut() {
        return movedOut;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
