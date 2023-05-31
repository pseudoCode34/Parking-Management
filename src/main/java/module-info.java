module com.example.parkingmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;


    opens com.example.parkingmanagement to javafx.fxml;
    exports com.example.parkingmanagement;
}