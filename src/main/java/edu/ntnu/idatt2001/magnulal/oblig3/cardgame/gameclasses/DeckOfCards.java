package edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck containing a list of 52 playing cards (class 'PlayingCard')
 * the class has a static list of suits (char[] suit) and also for the
 * range of values each different suit is given (int[] faceValues).
 * The constructor utilizes these lists to generate an ArrayList with
 * 52 playing cards (ArrayListPlayingCard deckList)
 * @author ntnu _ further developed by ntnu.stud: magnulal
 * @version 2022-03-30
 */
public class DeckOfCards {
    //List of values for possible suits
    private static final char[] suit = {'S','H','D','C'};
    //List of values for possible faces for each one of the suits
    private static final int[] faceValues = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private final ArrayList<PlayingCard> deckList;

    /**
     * Constructor creating a deck of cards. Any deck has 52 playing cards
     * The constructor generates the deck by assigning all 13 of the values
     * in int[] faceValues to each of the different suits in char[] suit,
     * thereby generating a total of 52 unique playing cards.
     */
    public DeckOfCards() {
        this.deckList = new ArrayList<>();
        for (char c: suit){
            for (int i: faceValues){
                deckList.add(new PlayingCard(c,i));
            }
        }
    }
    /**
     * The method picks n cards from the deck randomly via a Random object's ints-stream
     * which specifies the integer range of the random integers. Then the stream keeps
     * a total of n (limit), unique (distinct) index-positions. These are then used to mapToObj of
     * the deckList, which gets the random hand.
     * @param n, is the amount of cards in the hand that is dealt
     * @return ListPlayingCard which is a hand of n randomly chosen cards from this deckList
     * throws IllegalArgumentException, if n is outside requested interval
     */
    public List<PlayingCard> dealHand(int n) throws IllegalArgumentException{
        if(n < 1) throw new IllegalArgumentException("Cannot pick less than one card, please let hand-size be any "
                + "integer from 1 to 52");
        if(n > 52) throw new IllegalArgumentException("Cannot pick more than 52 cards for a hand, since that " +
                "is the size of any given deck, please let hand-size be an integer from 1 to 52");
        return new Random().ints(0, deckList.size())
                .distinct()
                .limit(n)
                .mapToObj(deckList::get)
                .toList();
    }
    /**
     * Accessor method that returns this deck of cards in an ArrayList with PlayingCards
     * @return ArrayListPlayingCard deckList
     */
    public ArrayList<PlayingCard> getDeckList() {
        return deckList;
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                deckList +
                "}";
    }
}

