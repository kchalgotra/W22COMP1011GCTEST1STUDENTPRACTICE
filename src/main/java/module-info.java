module com.example.w22comp1011gctest1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.w22comp1011gctest1 to javafx.fxml;
    exports com.example.w22comp1011gctest1;
}