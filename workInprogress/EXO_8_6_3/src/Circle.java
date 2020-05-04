import java.awt.*;

/**
 * This class represent a circle
 */
public class Circle extends Figure{

    private int mDiametre;

    /**
     * The constructor
     * @param p        point
     * @param c        the color of the circle
     * @param diametre diametre of the circle.
     */
    public Circle(Point p, Color c, int diametre) {
        super(p, c);
        this.mDiametre = diametre;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawOval((int)this.mPoint.getX(), (int)this.mPoint.getY(), mDiametre, mDiametre);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "mDiametre=" + mDiametre +
                ", mPoint=[x: " + mPoint.getX() + ", y: " + mPoint.getY() + " ]" +
                ", mColor=" + mColor +
                '}';
    }
}
