package card;

/**
 *
 * @author zach frehner
 * @version 1
 */
public class SetCard extends Card {

    private String shape;
    private int number;
    private String shading;
    private String color;

    /**
     * @param cardText
     * default constructor
     *
     */

    public SetCard(String cardText) {
        super(cardText);
    }

    /**
     * @param shape shape
     * @param number rank
     * @param shading shading
     * @param color color
     */
    public SetCard(String shape, int number, String shading, String color) {
        super(shape + " of " + number + " of " + shading + " of " + color);
        this.shape = shape;
        this.number = number;
        this.shading = shading;
        this.color = color;

    }

    /**
     * @return the shape of the set card
     */
    public String getShape() {
        return shape;
    }

    /**
     * @return the number / rank of the set card
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return the shading of the set card
     */
    public String getShading() {
        return shading;
    }

    /**
     * @return the color of the set card
     */
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {

        return shape + " of " + number + " of " + shading + " of " + color;
    }
}
