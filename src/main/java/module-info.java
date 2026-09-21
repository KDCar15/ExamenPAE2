module com.uamv.examen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uamv.examen to javafx.fxml;
    exports com.uamv.examen;
}