package com.carpark.model;

import com.carpark.controller.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class ParkVisitorsTest {

    private CarPark carPark;
    @BeforeEach
    void setUp(){
        carPark = new CarPark();
        Post post = new Post();
        post.addCarHurd(carPark);
    }
    @Test
    public void sortByPrice(){

        Comparator<ParkVisitor> priceComparator = Comparator.comparingInt(ParkVisitor::getPrice);
        List<ParkVisitor> subjects = carPark.allParkVisitors().getAll();
        subjects.sort(priceComparator);
        carPark.sortByPrice();
        for (int i = 0; i < subjects.size(); i++)
            Assertions.assertEquals(subjects.get(i).getPrice(), carPark.allParkVisitors().get(i).getPrice());

    }
    @Test
    public void sortByWeight(){
        Comparator<ParkVisitor> weightComparator = Comparator.comparingInt(ParkVisitor::getWeight);
        List<ParkVisitor> subjects = carPark.allParkVisitors().getAll();
        subjects.sort(weightComparator);
        carPark.sortByWeight();
        for (int i = 0; i < subjects.size(); i++) {
            Assertions.assertEquals(subjects.get(i).getWeight(), carPark.allParkVisitors().get(i).getWeight());
        }
    }
    @Test
    public void searchByName(){
        for (ParkVisitor subject : carPark.allParkVisitors().getAll()) {
            ParkVisitors subjectsToBuy2 = new ParkVisitors();
            List<ParkVisitor> subjects = carPark.allParkVisitors().getAll();
            for (ParkVisitor subjectToBuy : subjects)
                if (Objects.equals(subject.getName(), subjectToBuy.getName())) subjectsToBuy2.add(subjectToBuy);
            Assertions.assertEquals(subjectsToBuy2, carPark.allParkVisitors().searchByName(subject.getName()));
        }
    }

    @Test
    public void searchByPrice(){
        for (ParkVisitor subject : carPark.allParkVisitors().getAll()) {
            ParkVisitors subjectsToBuy2 = new ParkVisitors();
            List<ParkVisitor> subjects = carPark.allParkVisitors().getAll();
            for (ParkVisitor subjectToBuy : subjects)
                if (subject.getPrice() == subjectToBuy.getPrice()) subjectsToBuy2.add(subjectToBuy);
            Assertions.assertEquals(subjectsToBuy2, carPark.allParkVisitors().searchByPrice(Integer.toString(subject.getPrice())));
        }
    }

    @Test
    public void priceOfAll(){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (ParkVisitor subjectToBuy : carPark.allParkVisitors().getAll()) {
                sum += subjectToBuy.getPrice();
            }
            Assertions.assertEquals("Price of all ParkVisitor " + sum, carPark.allParkVisitors().priceOfAll());
            setUp();
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        Assertions.assertFalse(executionTime > 50,"Время выполнения превысило 5 миллисекунд");
    }
    @Test
    public void weightOfAll(){
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (ParkVisitor subjectToBuy : carPark.allParkVisitors().getAll()) {
                sum += subjectToBuy.getWeight();
            }
            Assertions.assertEquals("Weight of all ParkVisitor " + sum, carPark.allParkVisitors().weightOfAll());
            setUp();
        }
    }
    @Test
    public void maxWeight(){
        for (int i = 0; i < 100; i++) {
            ParkVisitor maxSubjectToBuy = carPark.allParkVisitors().getAll().get(carPark.allParkVisitors().getAll().size() - 1);
            for (ParkVisitor subjectToBuy : carPark.allParkVisitors().getAll()) {
                if (maxSubjectToBuy.getWeight() < subjectToBuy.getWeight())
                    maxSubjectToBuy = subjectToBuy;
            }
            Assertions.assertEquals("ParkVisitor with max weight = " + maxSubjectToBuy, carPark.allParkVisitors().maxWeight());
            setUp();
        }
    }
    @Test
    public void maxPrice(){
        for (int i = 0; i < 100; i++) {
            ParkVisitor maxSubjectToBuy = carPark.allParkVisitors().getAll().get(carPark.allParkVisitors().getAll().size() - 1);
            for (ParkVisitor subjectToBuy : carPark.allParkVisitors().getAll()) {
                if (maxSubjectToBuy.getPrice() < subjectToBuy.getPrice())
                    maxSubjectToBuy = subjectToBuy;
            }
            Assertions.assertEquals("ParkVisitor with max price = " + maxSubjectToBuy, carPark.allParkVisitors().maxPrice());
            setUp();
        }
    }
}
