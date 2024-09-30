module com.aicherlenja.integralcalc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.aicherlenja.integralcalc to javafx.fxml;
    exports com.aicherlenja.integralcalc;
    exports com.aicherlenja.integralcalc.controller;
    opens com.aicherlenja.integralcalc.controller to javafx.fxml;
}