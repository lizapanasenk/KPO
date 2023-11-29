package com.carpark.model;

import com.carpark.controller.LocalManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ParkVisitors implements Serializable {
    private final Logger logger = LogManager.getLogger(ParkVisitors.class);
    private final List<ParkVisitor> parkVisitors;

    public ParkVisitors() {
        this.parkVisitors = new ArrayList<>();
    }

    public void sortByPrice(){
        Comparator<ParkVisitor> priceComparator = Comparator.comparingInt(ParkVisitor::getPrice);

        // Сортируем список с использованием компаратора
        parkVisitors.sort(priceComparator);
    }
    public void sortByWeight(){
        Comparator<ParkVisitor> priceComparator = Comparator.comparingInt(ParkVisitor::getWeight);

        // Сортируем список с использованием компаратора
        parkVisitors.sort(priceComparator);
    }
    public ParkVisitors searchByName(String name){
        ParkVisitors subjectsToBuy2 = new ParkVisitors();
        for (ParkVisitor parkVisitor: parkVisitors) {
            if (Objects.equals(name, parkVisitor.getName()))  subjectsToBuy2.add(parkVisitor);
        }
        return subjectsToBuy2;
    }
    public ParkVisitors searchByPrice(String price){
        ParkVisitors parkVisitors1 = new ParkVisitors();
        for (ParkVisitor parkVisitor: parkVisitors) {
            if (Integer.parseInt(price)==parkVisitor.getPrice()) parkVisitors1.add(parkVisitor);
        }
        return parkVisitors1;
    }
    public String priceOfAll(){
        try {
            if (parkVisitors.isEmpty())
                throw new Exception(LocalManager.getMessage().getString("arrayEmpty"));
            int sum = 0;
            for (ParkVisitor parkVisitor : parkVisitors) {
                sum += parkVisitor.getPrice();
            }
            return LocalManager.getMessage().getString("priceOfAllVisitor") + sum;
        }catch (Exception e){
            logger.error("Error",e);
            return LocalManager.getMessage().getString("PleaseAddVisitor");
        }
    }
    public String weightOfAll(){
        try {
            if (parkVisitors.isEmpty())
                throw new Exception(LocalManager.getMessage().getString("arrayEmpty"));
        int sum = 0;
        for (ParkVisitor parkVisitor: parkVisitors) {
            sum+=parkVisitor.getWeight();
        }
        return LocalManager.getMessage().getString("WeightOfAllVisitor")+sum;
        }catch (Exception e){
            logger.error("Error",e);
            return LocalManager.getMessage().getString("PleaseAddVisitor");
        }
    }
    public String maxWeight() {
        try {
            if (parkVisitors.isEmpty())
                throw new Exception(LocalManager.getMessage().getString("arrayEmpty"));
            ParkVisitor parkVisitor = parkVisitors.get(parkVisitors.size() - 1);
            for (ParkVisitor parkVisitor1 : parkVisitors) {
                if (parkVisitor.getWeight() < parkVisitor1.getWeight())
                    parkVisitor = parkVisitor1;
            }
            return LocalManager.getMessage().getString("VisitorWithMaxWeight") + parkVisitor;
        } catch (Exception e) {
            logger.error("Error", e);
            return LocalManager.getMessage().getString("PleaseAddVisitor");
        }
    }
    public String maxPrice(){
            try {
                if (parkVisitors.isEmpty())
                    throw new Exception(LocalManager.getMessage().getString("arrayEmpty"));
        ParkVisitor parkVisitor = parkVisitors.get(parkVisitors.size()-1);
        for (ParkVisitor parkVisitor1: parkVisitors) {
            if(parkVisitor.getPrice()<parkVisitor1.getPrice())
                parkVisitor=parkVisitor1;
        }
        return LocalManager.getMessage().getString("VisitorWithMaxPrice")+parkVisitor;
    }catch (Exception e){
        logger.error("Error",e);
        return LocalManager.getMessage().getString("PleaseAddVisitor");
        }
    }
    public ParkVisitor get(int number) {
        return parkVisitors.get(number);
    }
    public List<ParkVisitor> getAll() {
        return parkVisitors;
    }

    public void add(ParkVisitor subjectToBuy) {
        this.parkVisitors.add(subjectToBuy);
    }
    public int size(){
        return parkVisitors.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ParkVisitor parkVisitor : parkVisitors)
            result.append(parkVisitor).append("\n");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkVisitors that = (ParkVisitors) o;
        return Objects.equals(parkVisitors, that.parkVisitors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkVisitors);
    }
}
