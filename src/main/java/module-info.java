module com.mycompany.esportmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.esportmanager to javafx.fxml;
    exports com.mycompany.esportmanager;
}
