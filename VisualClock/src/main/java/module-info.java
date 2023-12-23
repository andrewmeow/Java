module com.example.visualclock {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.visualclock to javafx.fxml;
    exports com.example.visualclock;
}