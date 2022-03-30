package edu.ntnu.idatt2001.magnulal.oblig3.cardgame.view;

import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses.CardHand;

/**
 * View class for printing of a CardHand
 * @author magnulal
 * @version 2022-03-30
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
}
