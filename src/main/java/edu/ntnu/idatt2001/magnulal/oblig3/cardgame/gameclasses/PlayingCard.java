package edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses;

import java.util.Objects;

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 * @author ntnu _ further developed by ntnu.stud: magnulal
 * @since 2020-01-10
 * @version 2022-03-21
 */
public class PlayingCard {

    private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    private final int face; // a number between 1 and 13

    /**
     * Creates an instance of a PlayingCard with a given suit and face.
     * @param suit The suit of the card, as a single character. 'S' for Spades,
     *             'H' for Heart, 'D' for Diamonds and 'C' for clubs
     * @param face The face value of the card, an integer between 1 and 13
     */
    public PlayingCard(char suit, int face) {
        this.suit = suit;
        this.face = face;
    }

    /**
     * Returns the suit and face of the card as a string.
     * A 4 of hearts is returned as the string "H4".
     * @return the suit and face of the card as a string
     */
    public String getAsString() {
        return String.format("%s%s", suit, face);
    }

    /**
     * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for Clubs
     * @return the suit of the card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Returns the face of the card (value between 1 and 13).
     * @return the face of the card
     */
    public int getFace() {
        return face;
    }

    @Override
    public String toString() {
        return this.getAsString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard that = (PlayingCard) o;
        return suit == that.suit && face == that.face;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face);
    }
}

