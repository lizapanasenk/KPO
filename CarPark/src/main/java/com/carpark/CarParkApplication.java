package com.carpark;

import com.carpark.model.CarPark;
import com.carpark.view.ShowWindow;
import com.carpark.view.WriteSavedPost;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class CarParkApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        try {
            new ShowWindow(WriteSavedPost.getCarPark(),primaryStage);
        } catch (IOException | ClassNotFoundException e) {
            new ShowWindow(new CarPark(),primaryStage);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}