package de.liondeer.excel2json;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label testLabel;
    private File xlsx;

    @FXML
    protected void onOpenExcelFileClick(ActionEvent event) {
        Window w = ((Node) event.getTarget()).getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Excel-Datei öffnen...");
        File f = fc.showOpenDialog(w);
        if (f != null) {
            xlsx = f;
            welcomeText.setText(f.getName());
        }
    }

    public void readFile() {
        try {
            Workbook wb = WorkbookFactory.create(xlsx);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    public void Test() {
        testLabel.setOnDragDetected(event -> {
            Dragboard db = testLabel.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(testLabel.getText());
            db.setContent(content);
            event.consume();
        });
    }
}