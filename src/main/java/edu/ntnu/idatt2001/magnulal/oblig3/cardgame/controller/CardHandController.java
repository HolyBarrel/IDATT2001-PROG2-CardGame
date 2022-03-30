package edu.ntnu.idatt2001.magnulal.oblig3.cardgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses.*;

/**
 * Controller class for CardHand functionality
 * and visualization with JavaFX
 * Contains information on all JavaFX elements specified in
 * the resource file: 'main-view.fxml'
 * @author magnulal
 * @version 2022-03-30
 */
public class CardHandController {
    private CardHand currentCardHand;
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

    /**
     * Initialize method that occurs when the main-view is
     * initialized. Sets the text of labels to empty strings to
     * simulate an empty field
     */
    @FXML
    private void initialize() {
        cardsOfTheHand.setText("");
        sumOfFaces.setText("");
        cardsOfHearts.setText("");
        queenOfSpades.setText("");
        flushLabel.setText("");
    }

    /**
     * Help method to display the sum of the faces of the cards in the currently
     * dealt hand.
     */
    private void displaySumOfFaces(){
        sumOfFaces.setText(String.valueOf(currentCardHand.getSumOfHand()));
    }

    /**
     * Help method to display the cards of hearts contained in the currently
     * dealt hand. Displays 'No Hearts' if the dealt hand has no cards of Hearts.
     */
    private void displayCardsOfHearts(){
        cardsOfHearts.setText(currentCardHand.getCardsOfHearts());
    }

    /**
     * Method to check the currently dealt hand for:
     * sum of faces using 'displaySumOfFaces'-help-method
     * cards of hearts using 'displayCardsOfHearts'-help-method
     * flush (displays text: 'yes' or 'no')
     * queen of spades (displays text: 'yes' or 'no')
     * Note: the method will only run if the currentCardHand is unequal to
     * 'null' and will therefore only check a card hand if it has been dealt one.
     * @param actionEvent, occurs on button click of the button 'btnCheckHand'
     */
    @FXML
    protected void checkHand(ActionEvent actionEvent) {
        if(currentCardHand != null){
            displaySumOfFaces();
            displayCardsOfHearts();
            if (currentCardHand.checkFlush()){
                flushLabel.setText(("Yes"));
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

    /**
     * Method that generates a new deck of cards and deals a card hand of five cards
     * from this deck. The method updates the text of the label 'cardsOfTheHand'
     * and also the runtime stored attribute 'currentCardHand' of this CardHandController
     * @param actionEvent, occurs on button click of the button 'btnCheckHand'
     */
    @FXML
    protected void dealHand(ActionEvent actionEvent) {
        this.currentCardHand = new CardHand(new DeckOfCards().dealHand(5));
        cardsOfTheHand.setText(currentCardHand.toString());
    }
}