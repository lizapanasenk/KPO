package com.carpark.view;


import com.carpark.controller.LocalManager;
import com.carpark.controller.Post;
import com.carpark.model.CarPark;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ShowWindow {
    public ShowWindow(CarPark carPark ,Stage primaryStage){

        ObservableList<String> langs = FXCollections.observableArrayList("en", "ru");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setValue("ru"); // устанавливаем выбранный элемент по умолчанию

        // получаем выбранный элемент
        langsComboBox.setOnAction(event ->

        {
            LocalManager.setCurrentLocale(new Locale(langsComboBox.getValue()));
            primaryStage.setScene(showMainScene(carPark,langsComboBox));
        });
        primaryStage.setScene(showMainScene(carPark,langsComboBox));
        primaryStage.setTitle("CarPark");
        primaryStage.show();
    }

    private Scene showMainScene(CarPark carPark, ComboBox<String> langsComboBox){
        ResourceBundle message= LocalManager.getMessage();
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(50);
        textArea.setPrefRowCount(25);



        Button btnAdd = new Button(message.getString("btnAdd"));
        btnAdd.setFont(new Font(15));
        btnAdd.setOnAction(event -> textArea.setText(new Post().addCar(carPark)));

        Button btnHurdAdd = new Button(message.getString("btnHurdAdd"));
        btnHurdAdd.setFont(new Font(15));
        btnHurdAdd.setOnAction(event -> textArea.setText(new Post().addCarHurd(carPark)));

        Button btnClear = new Button(message.getString("btnClear"));
        btnClear.setFont(new Font(15));
        btnClear.setOnAction(event -> textArea.clear());

        Button btnPriceOfAllVisitor = new Button(message.getString("btnPriceOfAllVisitor"));
        btnPriceOfAllVisitor.setFont(new Font(15));
        btnPriceOfAllVisitor.setOnAction(event -> textArea.setText(carPark.priceOfAllParkVisitor()));

        Button btnWeightOfAllVisitor = new Button(message.getString("btnWeightOfAllVisitor"));
        btnWeightOfAllVisitor.setFont(new Font(15));
        btnWeightOfAllVisitor.setOnAction(event -> textArea.setText(carPark.weightOfAllParkVisitors()));

        btnWeightOfAllVisitor.setOnAction(event -> textArea.setText(carPark.weightOfAllParkVisitors()));

        Button btnVisitorWithMaxPrice = new Button(message.getString("btnVisitorWithMaxPrice"));
        btnVisitorWithMaxPrice.setFont(new Font(15));

        btnVisitorWithMaxPrice.setOnAction(event -> textArea.setText(carPark.ParkVisitorWithMaxPrice()));

        Button btnVisitorWithMaxWeight = new Button(message.getString("btnVisitorWithMaxWeight"));
        btnVisitorWithMaxWeight.setFont(new Font(15));

        btnVisitorWithMaxWeight.setOnAction(event -> textArea.setText(carPark.ParkVisitorWithMaxWeight()));

        Button btnAllVisitor = new Button(message.getString("btnAllVisitor"));
        btnAllVisitor.setFont(new Font(15));

        btnAllVisitor.setOnAction(event -> textArea.setText(carPark.allParkVisitors().toString()));

        Button btnAllVisitorToFile = new Button(message.getString("btnAllVisitorToFile"));
        btnAllVisitorToFile.setFont(new Font(15));

        btnAllVisitorToFile.setOnAction(event -> textArea.setText(carPark.allParkVisitorsToFile()));


        Button btnSortByPrice = new Button(message.getString("btnSortByPrice"));
        btnSortByPrice.setFont(new Font(15));

        btnSortByPrice.setOnAction(event -> carPark.sortByPrice());


        Button btnSortByWeight = new Button(message.getString("btnSortByWeight"));
        btnSortByWeight.setFont(new Font(15));

        btnSortByWeight.setOnAction(event -> carPark.sortByWeight());


        TextField textField = new TextField();
        textField.setFont(new Font(15));


        Button btnSearchByPrice = new Button(message.getString("btnSearchByPrice"));
        btnSearchByPrice.setFont(new Font(15));

        btnSearchByPrice.setOnAction(event -> textArea.setText(carPark.searchByPrice(textField.getText())));


        Button btnSearchByName = new Button(message.getString("btnSearchByName"));
        btnSearchByName.setFont(new Font(15));

        btnSearchByName.setOnAction(event -> textArea.setText(carPark.searchByName(textField.getText())));

        Button btnAmountOfOperation = new Button(message.getString("btnAmountOfOperation"));
        btnAmountOfOperation.setFont(new Font(15));

        btnAmountOfOperation.setOnAction(event -> textArea.setText(carPark.getAmountOfOperation()));


        Button btnSave = new Button(message.getString("btnSave"));
        btnSave.setFont(new Font(15));

        btnSave.setOnAction(event -> {
            try {
                WriteSavedPost.setCarPark(carPark);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Button btnNew = new Button(message.getString("btnNew"));
        btnNew.setFont(new Font(15));

        btnNew.setOnAction(event -> {
            carPark.clear();
        });

        FlowPane root = new FlowPane(10,10,langsComboBox, textArea
                ,btnAdd,btnHurdAdd,btnClear,btnPriceOfAllVisitor,btnWeightOfAllVisitor
                ,btnVisitorWithMaxPrice,btnVisitorWithMaxWeight,btnAllVisitor,btnAllVisitorToFile,btnSortByPrice,btnSortByWeight,textField
                ,btnSearchByPrice,btnSearchByName,btnAmountOfOperation,btnSave,btnNew

        );
        root.setAlignment(Pos.CENTER);

      return new Scene(root, 650, 820);
    }
}
