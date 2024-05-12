package com.example.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ParametresController {
//    @FXML
//    private ImageView imageView;
    @FXML
    private Circle mycircle;
    public void choisirImage(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        Stage stage = (Stage) mycircle.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            mycircle.setFill(new ImagePattern(image));
           // imageView.setImage(image);
        }
    }
}
