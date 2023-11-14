package com.carpark;

import com.carpark.view.ShowWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class CarParkApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        new ShowWindow(primaryStage);
    }
    public static void main(String[] args) {
        launch();
    }
}