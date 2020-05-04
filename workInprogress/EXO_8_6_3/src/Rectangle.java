import java.awt.*;

/**
 * This class represent a rectangle
 */
public class Rectangle extends Figure{

    private int mWidth;
    private int mHeight;

    /**
     * The constructor
     * @param p      point
     * @param c      color of the rectangle
     * @param width  width of the rectangle
     * @param height height of the rectangle.
     */
    public Rectangle(Point p, Color c, int width, int height) {
        super(p, c);
        mHeight = height;
        mWidth  = width;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(mColor);
        g.drawRect((int)this.mPoint.getX(), (int)this.mPoint.getY(), mWidth, mHeight);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "mWidth=" + mWidth +
                ", mHeight=" + mHeight +
                ", mPoint=[x: " + mPoint.getX() + ", y: " + mPoint.getY() + " ]"+
                ", mColor=" + mColor+
                '}';
    }
}
