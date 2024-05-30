module org.wesselbiemans.politiedatabasemanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.wesselbiemans.politiedatabasemanager to javafx.fxml;
    exports org.wesselbiemans.politiedatabasemanager;
}