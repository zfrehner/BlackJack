package deck;

import card.StandardCard;


/**
 * This class constructs the standard 52 card deck for games like blackjack
 * and poker.
 * @author Zach Frehner
 * @version 1.0
 */
public class StandardDeck extends Deck {

    public static final String[] RANK = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "Jack", "Queen", "King"};
    public static final String[] SUIT = {"Hearts", "Diamonds", "Spades", "Clubs"};



    /**
     * constructs the standard deck
     */
    public StandardDeck() {
        //super();

        for (int i = 0; i < SUIT.length ; i++) {
            for (int j = 0; j < RANK.length; j++) {
                StandardCard card = new StandardCard(RANK[j], SUIT[i]);
                addCard(card);


            }
        }
    }

    @Override
    public StandardCard dealTopCard() {
        return (StandardCard) super.dealTopCard();
    }
}
