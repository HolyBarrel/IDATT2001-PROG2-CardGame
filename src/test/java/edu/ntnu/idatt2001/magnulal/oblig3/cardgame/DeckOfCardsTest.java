package edu.ntnu.idatt2001.magnulal.oblig3.cardgame;

import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses.DeckOfCards;
import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses.PlayingCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DeckOfCardsTest {
    @Nested
    @DisplayName("Test for the constructor of DeckOfCards")
    public class ConstructorConfirmation {
        @Test
        @DisplayName("Initializing a DeckOfCards using the constructor")
        public void initializingADeckOfCardsWithTheConstructor() {
            try {
                DeckOfCards deckOfCards1 = new DeckOfCards();
                assertEquals(52, deckOfCards1.getDeckList().size());
            } catch (IllegalArgumentException e) {
                fail("The test - 'initializingADeckOfCardsWithTheConstructor' - failed with the message: " + e.getMessage());
            }
        }
    }
    @Nested
    @DisplayName("Tests for dealHand-method of DeckOfCards class")
    public class TestsForDealHandMethod {
        @Nested
        @DisplayName("Positive tests for dealHand-method of DeckOfCards class")
        public class PositiveTestsForDealHandMethod {
            @Test
            @DisplayName("Checking that the dealHand-method deals the correct amount of cards")
            public void checkingThatDealHandReturnsRightAmountOfCardsToAHand() {
                DeckOfCards deckOfCards1 = new DeckOfCards();
                List<PlayingCard> testList = deckOfCards1.dealHand(5);
                assertEquals(5, testList.size());
            }
            @Test
            @DisplayName("Checking that the dealHand-method deals unique cards")
            public void checkingThatDealHandReturnsOnlyUniqueCards() {
                DeckOfCards deckOfCards1 = new DeckOfCards();
                List<PlayingCard> testList = deckOfCards1.dealHand(5);
                //Checks that there are five unique elements in the list
                assertEquals(5, testList.stream().distinct().toList().size());
            }
        }
        @Nested
        @DisplayName("Negative tests for dealHand-method of DeckOfCards class")
        public class NegativeTestsForDealHandMethod {
            @Test
            @DisplayName("Trying to deal a hand with 0 cards")
            public void dealingAHandOfZeroCards() {
                try {
                    DeckOfCards deckOfCards1 = new DeckOfCards();
                    deckOfCards1.dealHand(0);
                } catch (IllegalArgumentException e) {
                    assertEquals("Cannot pick less than one card, " +
                            "please let hand-size be any integer from 1 to 52", e.getMessage());
                }
            }
            @Test
            @DisplayName("Trying to deal a hand with -1 cards")
            public void dealingAHandOfNegativeCards() {
                try {
                    DeckOfCards deckOfCards1 = new DeckOfCards();
                    deckOfCards1.dealHand(-1);
                } catch (IllegalArgumentException e) {
                    assertEquals("Cannot pick less than one card, " +
                            "please let hand-size be any integer from 1 to 52", e.getMessage());
                }
            }
            @Test
            @DisplayName("Trying to deal a hand with more than 52 cards")
            public void dealingAHandWithMoreThan52Cards() {
                try {
                    DeckOfCards deckOfCards1 = new DeckOfCards();
                    deckOfCards1.dealHand(53);
                } catch (IllegalArgumentException e) {
                    assertEquals("Cannot pick more than 52 cards for a hand, since that " +
                            "is the size of any given deck, please let hand-size be an integer " +
                            "from 1 to 52", e.getMessage());
                }
            }
        }
    }
}

