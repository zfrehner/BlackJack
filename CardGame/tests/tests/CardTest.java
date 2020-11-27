package tests;

import card.Card;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zach frehner
 * @version 1
 */
public class CardTest {

    /**
     * tests the constructor for the Card class
     */
    @Test
    public void testConstructorCard() {
        Card card = new Card("King of Spades");

        assertEquals("Card text is incorrect", "King of Spades", card.getCardText());


    }

    /**
     * tests the toString method for the card class
     */
    @Test
    public void testToString() {
        Card card = new Card("Ace of Clubs");

        assertEquals("toString expected to be Ace of Clubs", "Ace of Clubs", card.getCardText());

    }
}
