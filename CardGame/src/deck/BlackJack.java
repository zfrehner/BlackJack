package deck;

import card.Card;
import card.StandardCard;
import deck.Deck;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 * @author Zach Frehner and John Laygo
 * @version 1.0
 */
public class BlackJack {
    //fields
    private int playerTotal;
    private int dealerTotal;
    private StandardDeck deck;

    /**
     *
     */
    public BlackJack() {
        deck = new StandardDeck();
        deck.shuffle();
        setDealerTotal(0);
        setPlayerTotal(0);
        welcome();

    }

    /**
     * @return
     */
    public int getPlayerTotal() {
        return playerTotal;
    }

    /**
     * @return
     */
    public int getDealerTotal() {
        return dealerTotal;
    }

    /**
     * @param total
     */
    public void setPlayerTotal(int total) {
        if(total == 0) {
            playerTotal = 0;
        }
        else {
            playerTotal += total;
        }
    }

    /**
     * @param total
     */
    public void setDealerTotal(int total) {
        if(total == 0) {
            dealerTotal = 0;
        }
        else {
            dealerTotal += total;
        }
    }

    /**
     * @return
     */
    public Stream<StandardCard> dealTwoCards() {
        if(deck.cardCount() < 2) {
            deck.shuffle();
            System.out.println("No more cards, shuffling deck...");
        }
        //calls dealTopCard() and puts them in a stream
        ArrayList<StandardCard> twoCards = new ArrayList<>();
        twoCards.add(deck.dealTopCard());
        twoCards.add(deck.dealTopCard());

        return twoCards.stream();

    }

    /**
     * @return
     */
    public StandardCard dealOneCard() {
        if(deck.cardCount() == 0) {
            deck.shuffle();
            System.out.println("No more cards, shuffling deck...");
        }
       return deck.dealTopCard();
    }

    /**
     *
     */
    public void welcome() {
        System.out.println("Welcome to my BlackJack console program!");
        System.out.println("*****************************************");
        System.out.println();
        System.out.println("Generate a new Standard Deck of cards.");
        System.out.println("Shuffling Deck...");
    }

    @Override
    public String toString() {
        return "BlackJack{" +
                "playerTotal=" + playerTotal +
                ", dealerTotal=" + dealerTotal +
                ", deck=" + deck +
                '}';
    }
}
