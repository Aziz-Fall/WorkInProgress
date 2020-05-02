import java.awt.*;

public abstract class Figure implements Deplacement, Drawable{

    protected Point mPoint;
    protected Color mColor;

    public Figure(Point p, Color c){
        this.mPoint = p;
        this.mColor = c;
    }

    public Point getPoint() {
        return mPoint;
    }

    public void setPoint(Point point) {
        mPoint = point;
    }

    public Color getColor() {
        return mColor;
    }

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
