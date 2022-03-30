package edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses;

import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.view.CardHandView;

import java.util.List;
/**
 * A given card hand, with methods to check the values of the respective
 * PlayingCards of this hand
 * @author magnulal
 * @version 2022-03-30
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
     * A method utilizing a stream to return the total sum of the faces
     * of a card hand
     * @return int sum of hand faces
     */
    public int getSumOfHand(){
        return aCardHand.stream()
                .mapToInt(PlayingCard::getFace)
                .sum();
    }

    /**
     * A method returning all the cards with suit 'hearts' in the hand
     * @return String of the found heart cards, or 'No Hearts' if there are
     * none in the given hand
     */
    public String getCardsOfHearts(){
        List<String> cardsOfHearts = aCardHand.stream()
                .filter(c -> c.getSuit() == 'H')
                .map(PlayingCard::toString)
                .toList();
        if(aCardHand.stream()
                .filter(c -> c.getSuit() == 'H')
                .map(PlayingCard::toString)
                .toList().size() == 0) return "No Hearts";
        return CardHandView.printCardHandFromListOfCardStrings(cardsOfHearts);
    }

    /**
     * A method checking whether the hand contains a Queen of Spades
     * @return true if it does, else false
     */
    public boolean hasQueenOfSpades(){
        return aCardHand.stream()
                .filter(c -> c.getSuit() == 'S' && c.getFace() == 12)
                .toList().size() == 1;
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
        return CardHandView.printCardHand(this);
    }
}
