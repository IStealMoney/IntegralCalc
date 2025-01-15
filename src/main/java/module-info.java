module com.aicherlenja.integralcalc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.jfree.jfreechart;
    requires java.desktop;
    requires jfreechart.fx;

    opens com.aicherlenja.integralcalc to javafx.fxml;
    exports com.aicherlenja.integralcalc;
}