import java.awt.Graphics;
import java.io.Serializable;

/**
 * This interface allow to draw a figure in a component.
 */
public interface Drawable extends Serializable {
    public void draw(Graphics g);
}
