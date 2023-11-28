package com.carpark.view;


import com.carpark.controller.Post;
import com.carpark.model.CarPark;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowWindow {
    public ShowWindow(CarPark carPark ,Stage primaryStage){
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(50);
        textArea.setPrefRowCount(30);


        Button btnAdd = new Button("Add car");
        btnAdd.setFont(new Font(15));
        btnAdd.setOnAction(event -> textArea.setText(new Post().addCar(carPark)));


        Button btnHurdAdd = new Button("Add car hurd");
        btnHurdAdd.setFont(new Font(15));
        btnHurdAdd.setOnAction(event -> textArea.setText(new Post().addCarHurd(carPark)));

        Button btnClear = new Button("Clear textArea");
        btnClear.setFont(new Font(15));
        btnClear.setOnAction(event ->textArea.clear());

        Button btnPriceOfAllVisitor = new Button("Price Of All Visitor");
        btnPriceOfAllVisitor.setFont(new Font(15));

        btnPriceOfAllVisitor.setOnAction(event -> textArea.setText(carPark.priceOfAllParkVisitor()));

        Button btnWeightOfAllVisitor = new Button("Weight Of All Visitor");
        btnWeightOfAllVisitor.setFont(new Font(15));


        btnWeightOfAllVisitor.setOnAction(event -> textArea.setText(carPark.weightOfAllParkVisitors()));

        Button btnVisitorWithMaxPrice = new Button("Visitor With Max Price");
        btnVisitorWithMaxPrice.setFont(new Font(15));

        btnVisitorWithMaxPrice.setOnAction(event -> textArea.setText(carPark.ParkVisitorWithMaxPrice()));

        Button btnVisitorWithMaxWeight = new Button("Visitor With Max Weight");
        btnVisitorWithMaxWeight.setFont(new Font(15));

        btnVisitorWithMaxWeight.setOnAction(event -> textArea.setText(carPark.ParkVisitorWithMaxWeight()));

        Button btnAllVisitor = new Button("Print All Visitors");
        btnAllVisitor.setFont(new Font(15));

        btnAllVisitor.setOnAction(event -> textArea.setText(carPark.allParkVisitors().toString()));


        Button btnAllVisitorToFile = new Button("Print All Visitors in file");
        btnAllVisitorToFile.setFont(new Font(15));

        btnAllVisitorToFile.setOnAction(event -> textArea.setText(carPark.allParkVisitorsToFile()));


        Button btnSortByPrice = new Button("Sort By Price");
        btnSortByPrice.setFont(new Font(15));

        btnSortByPrice.setOnAction(event -> carPark.sortByPrice());


        Button btnSortByWeight = new Button("Sort By Weight");
        btnSortByWeight.setFont(new Font(15));

        btnSortByWeight.setOnAction(event -> carPark.sortByWeight());


        TextField textField = new TextField();
        textField.setFont(new Font(15));


        Button btnSearchByPrice = new Button("Search by price");
        btnSearchByPrice.setFont(new Font(15));

        btnSearchByPrice.setOnAction(event -> textArea.setText(carPark.searchByPrice(textField.getText())));


        Button btnSearchByName = new Button("Search by name");
        btnSearchByName.setFont(new Font(15));

        btnSearchByName.setOnAction(event -> textArea.setText(carPark.searchByName(textField.getText())));

        Button btnAmountOfOperation = new Button("Amount Of Operation");
        btnAmountOfOperation.setFont(new Font(15));

        btnAmountOfOperation.setOnAction(event -> textArea.setText(carPark.getAmountOfOperation()));


        Button btnSave = new Button("Save CarPark");
        btnSave.setFont(new Font(15));

        btnSave.setOnAction(event -> {
            try {
                WriteSavedPost.setCarPark(carPark);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Button btnNew = new Button("New CarPark");
        btnNew.setFont(new Font(15));

        btnNew.setOnAction(event -> {
            carPark.clear();
        });

        FlowPane root = new FlowPane(10,10, textArea
                ,btnAdd,btnHurdAdd,btnClear,btnPriceOfAllVisitor,btnWeightOfAllVisitor
                ,btnVisitorWithMaxPrice,btnVisitorWithMaxWeight,btnAllVisitor,btnAllVisitorToFile,btnSortByPrice,btnSortByWeight,textField
                ,btnSearchByPrice,btnSearchByName,btnAmountOfOperation,btnSave,btnNew

        );
        root.setAlignment(Pos.CENTER);

        primaryStage.setTitle("CarPark");
        primaryStage.setScene(new Scene(root, 650, 700));
        primaryStage.show();
    }
}
