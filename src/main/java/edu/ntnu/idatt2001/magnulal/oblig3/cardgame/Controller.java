package edu.ntnu.idatt2001.magnulal.oblig3.cardgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses.*;

/**
 * TODO:COMMENT
 */
public class Controller {
    private CardHand currentCardHand;
    /**
     * TODO:comment
     */
    public Controller() {
    }

    @FXML
    private Label cardsOfTheHand;
    @FXML
    private Label sumOfFaces;
    @FXML
    private Button btnCheckHand;
    @FXML
    private Label cardsOfHearts;
    @FXML
    private AnchorPane displayField;
    @FXML
    private Label queenOfSpades;
    @FXML
    private Label flushLabel;
    @FXML
    private Button btnDealHand;

    private void displaySumOfFaces(){
        sumOfFaces.setText(String.valueOf(currentCardHand.getSumOfHand()));
    }
    private void displayCardsOfHearts(){
        cardsOfHearts.setText(currentCardHand.getCardsOfHearts());
    }
    @FXML
    protected void checkHand(ActionEvent actionEvent) {
        if(currentCardHand != null){
            displaySumOfFaces();
            displayCardsOfHearts();
            if (currentCardHand.checkFlush()){
                flushLabel.setText("Yes");
            }else {
                flushLabel.setText("No");
            }
            if(currentCardHand.hasQueenOfSpades()){
                queenOfSpades.setText("Yes");
            }else {
                queenOfSpades.setText("No");
            }
        }
    }
    @FXML
    protected void dealHand(ActionEvent actionEvent) {
        this.currentCardHand = new CardHand(new DeckOfCards().dealHand(5));
        cardsOfTheHand.setText(currentCardHand.toString());
    }
}