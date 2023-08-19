module de.liondeer.excel2json {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.liondeer.excel2json to javafx.fxml;
    exports de.liondeer.excel2json;
}