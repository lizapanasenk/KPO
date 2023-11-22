package com.carpark.model;

public class CarPark {
        private final ParkVisitors parkVisitorList;
        private int amountOfOperation;
        public CarPark() {
                this.parkVisitorList = new ParkVisitors();
                this.amountOfOperation = 0;
        }

        public void addParkVisitor(ParkVisitor parkVisitor){
                parkVisitorList.add(parkVisitor);
                amountOfOperation++;
        }

        public String priceOfAllParkVisitor(){
                amountOfOperation++;

                return parkVisitorList.priceOfAll();
        }

        public String weightOfAllParkVisitors(){
                amountOfOperation++;

                return parkVisitorList.weightOfAll();
        }
        public String ParkVisitorWithMaxPrice(){
                amountOfOperation++;

                return parkVisitorList.maxPrice();
        }
        public String ParkVisitorWithMaxWeight(){

                amountOfOperation++;
                return parkVisitorList.maxWeight();
        }
        public void sortByPrice(){
                amountOfOperation++;

                parkVisitorList.sortByPrice();
        }
        public void sortByWeight(){
                amountOfOperation++;

                parkVisitorList.sortByWeight();
        }
        public ParkVisitors allParkVisitors(){
                amountOfOperation++;

                return parkVisitorList;
        }
//        public String allParkVisitorsToFile(){
//                Write writeToFile = new Write();
//                return writeToFile.WriteToFile(allSubjects().toString());
//        }
        public String searchByName(String name){
                amountOfOperation++;
                if(parkVisitorList.searchByName(name)!=null)
                        return parkVisitorList.searchByName(name).toString();
                return "No results";
        }
        public String searchByPrice(String price){
                amountOfOperation++;

                if(parkVisitorList.searchByPrice(price)!=null)
                        return parkVisitorList.searchByPrice(price).toString();
                return "No results";
        }
        public String getAmountOfOperation(){
                return "Amount of operation = "+amountOfOperation;
        }
}