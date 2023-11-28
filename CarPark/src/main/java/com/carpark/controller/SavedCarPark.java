package com.carpark.controller;

import com.carpark.model.CarPark;

import java.io.Serial;
import java.io.Serializable;

public class SavedCarPark implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private CarPark carPark;

    public SavedCarPark(CarPark carPark) {
        this.carPark = carPark;
    }

    public CarPark getCarPark() {
        return carPark;
    }

    public void setCarPark(CarPark carPark) {
        this.carPark = carPark;
    }
}
