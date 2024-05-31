module org.wesselbiemans.politiedatabasemanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.wesselbiemans.politiedatabasemanager to javafx.fxml;
    exports org.wesselbiemans.politiedatabasemanager;
}