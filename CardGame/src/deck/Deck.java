package deck;

import card.Card;
import java.util.ArrayList;

/**
 *
 * @author zach frehner
 * @version 1
 */
public class Deck {

    private ArrayList<Card> dealerPile;
    private ArrayList<Card> discardPile;

    /**
     * default constructor
     */
    public Deck() {
        this.dealerPile = new ArrayList<>();
        this.discardPile = new ArrayList<>();


    }

    /**
     * getter method for getting the dealer pile list
     * @return the dealer pile
     */
    public ArrayList<Card> getDealerPile() {
        return dealerPile;
    }

    /**
     * @param card a card from the standard deck
     */
    public void addCard(Card card) {
        dealerPile.add(card);

    }

    /**
     *
     */
    public void shuffle() {
        //add all the cards in the discard pile back to the dealer pile
        for (int i = 0; i < discardPile.size(); i++) {
                Card temp = discardPile.get(i);
                dealerPile.add(temp);
        }
        discardPile.clear();
        //then shuffle all the cards using Math.Random
        // shuffle
        for (int i = 0; i < dealerPile.size(); i++) {
            int rando = i + (int) (Math.random() * (dealerPile.size()-i));
            Card temp = dealerPile.get(rando);
            dealerPile.set(rando, dealerPile.get(i));
            dealerPile.set(i, temp);
        }
    }

    /**
     * @return removes the "top" card from the dealer pile and places it in the discard pile
     */
    public Card dealTopCard() {
        Card temp = dealerPile.get(0);
        dealerPile.remove(0);
        discardPile.add(temp);
        return temp;
    }

    /**
     * @return returns the number of cards in the dealer pile
     */
    public int cardCount() {
        return dealerPile.size();
    }

    @Override
    public String toString() {
        String temp = "";
        String temp2 = "";
        for (Card card : dealerPile) {
            temp += card + "\n";
        }
        for(Card card2 : discardPile) {
            temp2 += card2 + "\n";
        }
        return dealerPile.size() + " cards in deck" + "\n" + "*********************"
                + "\n" + temp + "\n" + discardPile.size() + " cards in discard pile" + "\n" + "****************"
                + "\n" + temp2;
    }
}
