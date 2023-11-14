package com.carpark.model;

import java.util.Date;

public class ParkVisitor {

    protected final Date movedIn;
    protected final Date movedOut;
    protected final int weight;
    protected final String nameOfParkVisitor;

    public ParkVisitor(Date movedIn, Date movedOut, int weight, String nameOfParkVisitor) {
        this.movedIn = movedIn;
        this.movedOut = movedOut;
        this.weight = weight;
        this.nameOfParkVisitor = nameOfParkVisitor;
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

    public String getNameOfParkVisitor() {
        return nameOfParkVisitor;
    }
}
