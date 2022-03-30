package edu.ntnu.idatt2001.magnulal.oblig3.cardgame.view;

import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses.CardHand;

import java.util.List;

/**
 * View class for printing of a CardHand
 * @author magnulal
 * @version 2022-03-30
 * This class is tested in 'CardHandTest'
 */
public class CardHandView {
    /**
     * Private constructor to hinder instantiation of this class, since
     * the class is only used for its static methods
     */
    private CardHandView(){}

    /**
     * Static method to return a String representation for the given hand
     * @param printHand, is a CardHand object
     * @return String representation of the parameter printHand
     */
    public static String printCardHand(CardHand printHand){
        StringBuilder sb = new StringBuilder();
        printHand.getCardHand().forEach(c -> sb.append(c).append("  "));
        return String.valueOf(sb);
    }
    /**
     * Static method to return a String representation of the given String
     * list parameter
     * @param printHand, is a List of String representations of cards
     * @return String representation of the parameter printHand
     */
    public static String printCardHandFromListOfCardStrings(List<String> printHand){
        StringBuilder sb = new StringBuilder();
        printHand.forEach(c -> sb.append(c).append("  "));
        return String.valueOf(sb);
    }
}
