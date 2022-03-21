package edu.ntnu.idatt2001.magnulal.oblig3.cardgame;
import edu.ntnu.idatt2001.magnulal.oblig3.cardgame.gameclasses.PlayingCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class PlayingCardTest {
    @Nested
    @DisplayName("Test for the constructor of PlayingCard")
    public class ConstructorConfirmation {
        @Test
        @DisplayName("Initializing a PlayingCard using the constructor")
        public void initializingAPlayingCardWithTheConstructor() {
            try {
                new PlayingCard('X', 30);
            } catch (IllegalArgumentException e) {
                fail("The test - 'initializingAPlayingCardWithTheConstructor' - " +
                        "failed with the message: " + e.getMessage());
            }
        }
    }
}
