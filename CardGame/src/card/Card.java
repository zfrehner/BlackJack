package card;

/**
 *
 * @author Zach Frehner
 * @version 1
 */
public class Card {

    private String cardText;

    /**
     * @param cardText the text of the card
     */
    public Card(String cardText) {
        this.cardText = cardText;

    }

    /**
     * default constructor
     */
    public Card() {
        this.cardText = "";
    }

    /**
     * @return the text of the dealt card
     */
    public String getCardText() {
        return cardText;
    }

    @Override
    public String toString() {
        return getCardText();
    }
}
