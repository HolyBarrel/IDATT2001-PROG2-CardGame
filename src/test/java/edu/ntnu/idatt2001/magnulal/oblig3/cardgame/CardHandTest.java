package edu.ntnu.idatt2001.magnulal.oblig3.cardgame;

import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardHandTest {
    @Nested
    @DisplayName("Tests for the constructor of the CardHand class")
    public class TestForTheConstructorOfCardHand {
        @Test
        @DisplayName("Initializing a CardHand using the constructor")
        public void initializingACardHandWithTheConstructor() {
            try{
                CardHand cardHand1 = new CardHand(new DeckOfCards().dealHand(5));
                assertEquals(5, cardHand1.getCardHand().size());
            }catch (IllegalArgumentException e){
                fail("The test - 'initializingACardHandWithTheConstructor' - failed with the message: " + e.getMessage());
            }
        }
    }
    @Nested
    @DisplayName("Tests for checkFlush-method of CardHand class")
    public class TestsForCheckFlushMethod {
        @Test
        @DisplayName("Checking that the checkFlush-method catches 100% as dealt 1-card-hands as flushes")
        public void checkingThatTheCheckFlushReturnsTrueWhenAHandHasOneCard() {
            CardHand cardHand1 = new CardHand(new DeckOfCards().dealHand(1));
            assertTrue(cardHand1.checkFlush());
        }
        @Test
        @DisplayName("Checking that the checkFlush-method catches about 0.2% as dealt 5-card-hands as flushes")
        //SOURCE: https://stattrek.com/poker/probability-of-flush.aspx, date 20.03.2022
        public void checkingThatTheCheckFlushReturnsTrueInApprox0p2PercentOf5erHands() {
            //Variable counting every flush
            double x = 0;
            for (int i = 0; i < 100000; i++) {
                CardHand cardHand1 = new CardHand(new DeckOfCards().dealHand(5));
                if (cardHand1.checkFlush()){
                    x++;
                }
            }
            //Expected to produce about 200 flushes per 100 000 hands of five cards dealt
            //System.out.println(x);
            //Checking that in fact it does result in flush in the correct amount of hands dealt
            assertEquals(2, Math.round(x/=100));
        }
        @Test
        @DisplayName("Checking that the checkFlush-method catches a four card hand flush as a flush")
        public void checkingThatTheCheckFlushReturnsTrueWhenTheHandIsAFlush() {
            List<PlayingCard> testList = new ArrayList<>();
            testList.add(new PlayingCard('C', 1));
            testList.add(new PlayingCard('C', 7));
            testList.add(new PlayingCard('C', 3));
            testList.add(new PlayingCard('C', 8));
            CardHand cardHand2 = new CardHand(testList);
            assertTrue(cardHand2.checkFlush());
        }
        @Test
        @DisplayName("Checking that the checkFlush-method returns false when the hand is not a flush")
        public void checkingThatTheCheckFlushReturnsFalseWhenTheHandIsNotAFlush() {
            List<PlayingCard> testList = new ArrayList<>();
            testList.add(new PlayingCard('H', 1));
            testList.add(new PlayingCard('C', 7));
            testList.add(new PlayingCard('H', 3));
            testList.add(new PlayingCard('C', 8));
            CardHand cardHand2 = new CardHand(testList);
            assertFalse(cardHand2.checkFlush());
        }

    }
    @Nested
    @DisplayName("Tests for GetSumOfHand-method of CardHand class")
    public class TestsForGetSumOfHandMethod {
        @Test
        @DisplayName("Checking that the sum of the hand is returned as expected")
        public void checkingThatTheGetSumOfHandReturnsExpectedSum() {
            List<PlayingCard> testList = new ArrayList<>();
            testList.add(new PlayingCard('H', 1));
            testList.add(new PlayingCard('C', 7));
            testList.add(new PlayingCard('H', 3));
            testList.add(new PlayingCard('C', 8));
            CardHand cardHand2 = new CardHand(testList);
            assertEquals(19,cardHand2.getSumOfHand());
        }
    }
    @Nested
    @DisplayName("Tests for hasQueenOfSpades-method of CardHand class")
    public class TestsForHasQueenOfSpades {
        @Test
        @DisplayName("Checking that the hasQueenOfSpades-method returns true when the hand has a queen of spades")
        public void checkingThatTheHasQueenOfSpadesReturnsTrueWhenExpectedTo() {
            List<PlayingCard> testList = new ArrayList<>();
            testList.add(new PlayingCard('H', 1));
            testList.add(new PlayingCard('C', 7));
            testList.add(new PlayingCard('S', 12));
            testList.add(new PlayingCard('C', 8));
            CardHand cardHand2 = new CardHand(testList);
            assertTrue(cardHand2.hasQueenOfSpades());
        }
        @Test
        @DisplayName("Checking that the hasQueenOfSpades-method returns false when the hand has a queen of spades")
        public void checkingThatTheHasQueenOfSpadesReturnsFalseWhenExpectedTo() {
            List<PlayingCard> testList = new ArrayList<>();
            testList.add(new PlayingCard('H', 1));
            testList.add(new PlayingCard('C', 7));
            testList.add(new PlayingCard('H', 12));
            testList.add(new PlayingCard('C', 8));
            CardHand cardHand2 = new CardHand(testList);
            assertFalse(cardHand2.hasQueenOfSpades());
        }
    }
    @Nested
    @DisplayName("Tests for GetCardsOfHearts-method of CardHand class")
    public class TestsForGetCardsOfHearts {
        @Test
        @DisplayName("Checking that the GetCardsOfHearts returns correct string")
        public void checkingThatTheGetCardsOfHeartsReturnsCorrectString() {
            List<PlayingCard> testList = new ArrayList<>();
            testList.add(new PlayingCard('H', 1));
            testList.add(new PlayingCard('C', 7));
            testList.add(new PlayingCard('H', 12));
            testList.add(new PlayingCard('C', 8));
            CardHand cardHand2 = new CardHand(testList);
            assertEquals("[H1, H12]", cardHand2.getCardsOfHearts());
        }
        @Test
        @DisplayName("Checking that the GetCardsOfHearts returns 'No Hearts'")
        public void checkingThatTheGetCardsOfHeartsReturnsNoHeartsWhenExpectedTo() {
            List<PlayingCard> testList = new ArrayList<>();
            testList.add(new PlayingCard('C', 1));
            testList.add(new PlayingCard('C', 7));
            testList.add(new PlayingCard('S', 12));
            testList.add(new PlayingCard('C', 8));
            CardHand cardHand2 = new CardHand(testList);
            assertEquals("No Hearts", cardHand2.getCardsOfHearts());
        }
    }
}

