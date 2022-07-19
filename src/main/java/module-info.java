module com.praktikum3.praktikum3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.praktikum3.praktikum3 to javafx.fxml;
    opens com.praktikum3.praktikum3.controller to javafx.fxml;
    opens com.praktikum3.praktikum3.entity to javafx.fxml;
    exports com.praktikum3.praktikum3;
    exports com.praktikum3.praktikum3.controller;
    exports com.praktikum3.praktikum3.entity;
}