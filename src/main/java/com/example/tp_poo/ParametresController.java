package com.example.tp_poo;

import com.example.tp_poo.models.Exception2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class ParametresController implements Initializable {
//    @FXML
//    private ImageView imageView;
    @FXML
    private Circle mycircle;
    @FXML
    private Label A;

    @FXML
    private AnchorPane sideBarancherPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SideBarScene.fxml"));
        Parent sidebar = null;
        try {
            sidebar = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sideBarancherPane.getChildren().add(sidebar);

    }
    public void choisirImage(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        Stage stage = (Stage) mycircle.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            mycircle.setFill(new ImagePattern(image));
            A.setVisible(false);
           // imageView.setImage(image);
        }
    }
    @FXML
    public void allerVersDocumentation(ActionEvent event){
        try{
            URI uri = new URI("https://github.com/Amine2240/Gestion-d-un-cabinet-d-orthophonie");
            Desktop.getDesktop().browse(uri);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
