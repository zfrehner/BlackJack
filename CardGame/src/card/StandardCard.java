package card;

/**
 *
 * @author Zach Frehner
 * @version 1
 */
public class StandardCard extends Card {

    private String rank;
    private String suit;

    /**
     * @param rank the numer Ace through King
     * @param suit 4 suits from standard playing cards
     */
    public StandardCard(String rank, String suit){
        super(rank + " of " + suit);
        this.rank = rank;
        this.suit = suit;

    }

    /**
     * @return the rank of the card
     */
    public String getRank() {
        return rank;
    }

    /**
     * method for getting the value of a cards rank
     * @return the value of the card rank
     */
    public int getRankValue() {
        //if value is 2-10 it returns the number


        //if jack, queen, king, it returns 10
        if(getRank().equals("Jack") || getRank().equals("Queen") || getRank().equals("King")) {
            return 10;
        }
        //ace returns 11
        if(getRank().equals("Ace")) {
            return 11;
        }
        return Integer.parseInt(getRank());
    }


    /**
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
