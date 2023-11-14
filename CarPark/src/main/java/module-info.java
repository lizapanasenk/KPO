module com.carpark.carpark {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.carpark.carpark to javafx.fxml;
    exports com.carpark.carpark;
}