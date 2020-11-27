package tests;

import card.StandardCard;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zach frehner
 * @version 1
 */
public class StandardCardTest {

    /**
     * tests the getRankValue() method of the Standard card class
     */
    @Test
    public void testGetRankValue() {
        StandardCard kCard = new StandardCard("King", "Hearts");
        StandardCard qCard = new StandardCard("Queen", "Hearts");
        StandardCard jCard = new StandardCard("Jack", "Hearts");
        StandardCard aCard = new StandardCard("Ace", "Hearts");

        assertEquals("Rank value is incorrect", 10, kCard.getRankValue());
        assertEquals("Rank value is incorrect", 10, qCard.getRankValue());
        assertEquals("Rank value is incorrect", 10, jCard.getRankValue());
        assertEquals("Rank value is incorrect", 11, aCard.getRankValue());
    }

    /**
     * tests the constructor of the standard card class
     */
    @Test
    public void testConstructorStandardCard() {
        StandardCard sCard = new StandardCard("4", "Hearts");

        assertEquals("Rank is incorrect", "4", sCard.getRank());
        assertEquals("Suit is incorrect", "Hearts", sCard.getSuit());
    }

    /**
     * tests the toString method of the standard card class
     */
    @Test
    public void testToString() {
        StandardCard sCard = new StandardCard("9", "Diamonds");

        assertEquals("toString expected to be Rank = 9, Suit = Diamonds","RANK = 9, SUIT = Diamonds",
                sCard.toString());

    }
}
