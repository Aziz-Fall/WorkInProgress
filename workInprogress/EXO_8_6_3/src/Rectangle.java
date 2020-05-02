import java.awt.*;

public class Rectangle extends Figure{

    private int mWidth;
    private int mHeight;

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
