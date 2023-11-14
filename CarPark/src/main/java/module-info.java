module com.carpark {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.carpark to javafx.fxml;
    exports com.carpark;
}