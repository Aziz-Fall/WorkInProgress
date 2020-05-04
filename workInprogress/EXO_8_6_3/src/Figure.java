import java.awt.*;

/**
 * this class represent a figure and implement the interface Deplacement and Drawable.
 */
public abstract class Figure implements Deplacement, Drawable{

    protected Point mPoint;
    protected Color mColor;

    /**
     * Contructor of the class Figure.
     * @param p point
     * @param c the color of the figure
     */
    public Figure(Point p, Color c){
        this.mPoint = p;
        this.mColor = c;
    }

    /**
     * Retourne the point that represent a figure
     * @return point
     */
    public Point getPoint() {
        return mPoint;
    }

    /**
     * Modified the coordinate of the figure
     * @param point a point
     */
    public void setPoint(Point point) {
        mPoint = point;
    }

    /**
     * Return the color of the figure
     * @return color
     */
    public Color getColor() {
        return mColor;
    }

    /**
     * Modified the color of the figure
     * @param color a color
     */
    public void setColor(Color color) {
        mColor = color;
    }

    @Override
    public void moveUp(int offset) {
        mPoint.move((int)mPoint.getX(), (int)mPoint.getY() - offset);
    }

    @Override
    public void moveDown(int offset) {
        mPoint.move((int)mPoint.getX(), (int)mPoint.getY() + offset);
    }

    @Override
    public void moveLeft(int offset) {
        mPoint.move((int)mPoint.getX() - offset, (int)mPoint.getY());
    }

    @Override
    public void moveRight(int offset) {
        mPoint.move((int)mPoint.getX() + offset, (int)mPoint.getY());
    }

    public abstract void draw(Graphics g);
}
