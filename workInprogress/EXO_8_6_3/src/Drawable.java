import java.awt.Graphics;
import java.io.Serializable;

public interface Drawable extends Serializable {
    public void draw(Graphics g);
}
