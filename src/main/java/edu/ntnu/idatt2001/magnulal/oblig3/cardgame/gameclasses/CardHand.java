package edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses;
import java.util.List;
/**
 * A given card hand, with methods to check the values of the respective
 * PlayingCards of this hand
 * @author ntnu _ further developed by ntnu.stud: magnulal
 * @since 2020-01-10
 * @version 2022-03-21 //TODO: UPDATE
 */
public class CardHand {
    private final List<PlayingCard> aCardHand;

    /**
     * Constructor to create a given card hand
     * @param aCardHand, is a list of PlayingCards, which is set to
     *                   this CardHand's attribute holding the list
     */
    public CardHand(List<PlayingCard> aCardHand) {
        this.aCardHand = aCardHand;
    }

    /**
     * Method utilizing a stream with a map that gives the suit-values of the cards in this hand
     * this is further processed by distinct which keeps all unique elements in the list. Lastly this
     * information is analyzed and does return a boolean if the list of unique suits only has one element
     * This means that all elements in the picked hand has the same suit value
     * @return true if the hand is a flush, false otherwise
     */
    public boolean checkFlush(){
        return aCardHand.stream()
                .map(PlayingCard::getSuit)
                .distinct().toList().size()
                == 1;
    }
    /**
     * Accessor method that returns this card hand in a list
     * @return ListPlayingCard aCardHand
     */
    public List<PlayingCard> getCardHand() {
        return aCardHand;
    }

    @Override
    public String toString() {
        return "CardHand{" + aCardHand + '}';
    }
}
