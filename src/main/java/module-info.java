module com.example.projetjava2023 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires javafx.web;

    opens com.example.projetjava2023 to javafx.fxml;
    exports com.example.projetjava2023;
}