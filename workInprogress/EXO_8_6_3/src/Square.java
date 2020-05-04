import java.awt.*;

/**
 * This class represent a Square.
 */
public class Square extends Figure {

    private int mSide;

    /**
     * Contructor of the class Figure.
     *
     * @param p    point
     * @param c    the color of the figure
     * @param side the side of the square
     */
    public Square(Point p, Color c, int side) {
        super(p, c);
        mSide = side;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(mColor);
        g.drawRect((int)this.mPoint.getX(), (int)this.mPoint.getY(), mSide, mSide);
    }
}
