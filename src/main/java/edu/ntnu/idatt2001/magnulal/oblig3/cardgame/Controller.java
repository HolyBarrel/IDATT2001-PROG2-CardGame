package edu.ntnu.idatt2001.magnulal.oblig3.cardgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
/**
 * TODO:COMMENT
 */
public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}