import java.awt.*;

public class Circle extends Figure{

    private int mDiametre;

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
                ", mPoint=" + mPoint +
                ", mColor=" + mColor +
                '}';
    }
}
